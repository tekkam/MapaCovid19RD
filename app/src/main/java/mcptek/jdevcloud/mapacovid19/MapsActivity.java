package mcptek.jdevcloud.mapacovid19;

import androidx.fragment.app.FragmentActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Carga de Datos:
        List<String> Provincia = new ArrayList<String>(CargarDatos().getProvincia());
        List<Integer> TotalProvincial = new ArrayList<Integer>(CargarDatos().getTotalProvincial());
        List<Double> lat = new ArrayList<Double>(CargarDatos().getLat());
        List<Double> lng = new ArrayList<Double>(CargarDatos().getLng());

        Iterator Prov = Provincia.iterator();
        Iterator TotProv= TotalProvincial.iterator();
        Iterator ilat = lat.iterator();
        Iterator ilng = lng.iterator();

        for (String a: CargarDatos().getProvincia()) {
            //Anadir coordenadas y ubicar en el mapa
            double latitud = (Double) ilat.next();
            double longitud = (Double) ilng.next();
            LatLng CoordenadasProv = new LatLng(latitud, longitud);
            mMap.addMarker(new MarkerOptions()
                    .position(CoordenadasProv)
                    .title("Provincia:"+Prov.next())
                    .snippet("Casos: "+TotProv.next())
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.virusicon))
            );
        }

        mMap.setMinZoomPreference(7.0f);
        mMap.setMaxZoomPreference(14.0f);

        LatLng Dominicana = new LatLng(18.938258, -70.648571);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Dominicana));
    }

    public ListasCasos CargarDatos() {
        //Crear instancia para una base de datos con el nombre que sera creada
        DBHelper DbAdmin = new DBHelper (this, "MapaCovidRD.db", null, 1);
        //Obtener acceso de lectura a la base de datos
        SQLiteDatabase BaseDatos = DbAdmin.getReadableDatabase();
        //Listas
        List<String> Provincias = new ArrayList<String>();
        List<Integer> CasosP = new ArrayList<Integer>();
        List<Double> Ordenadas = new ArrayList<Double>();
        List<Double> Abcisas = new ArrayList<Double>();

        try {
            //leer y cargar todos los datos de la tabla:
            Cursor fila = BaseDatos.rawQuery("select * from Casos", null);
            if (fila.moveToFirst()) {
                do{
                    Provincias.add(fila.getString(1));
                    CasosP.add(fila.getInt(2));
                    Ordenadas.add(fila.getDouble(3));
                    Abcisas.add(fila.getDouble(4));
                } while (fila.moveToNext());
            } else {
                Toast.makeText(this, "No se ha podido cargar la base de datos", Toast.LENGTH_SHORT).show();
            }
            fila.close();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            BaseDatos.close();
        }

        ListasCasos TotalCasos = new ListasCasos(Provincias,CasosP,Ordenadas,Abcisas);
        return TotalCasos;
    }
}

