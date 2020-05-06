package mcptek.jdevcloud.mapacovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Grilla extends AppCompatActivity {

    private Button bReportar, bVerMapa;
    private ListView lsGrilla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grilla);

        bReportar = findViewById(R.id.ReportarBTN);
        bVerMapa = findViewById(R.id.VerMapaBTN);
        lsGrilla = findViewById(R.id.GrillaLV);

        CargarListado();

        lsGrilla.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Preparacion de los argumentos
                 String texto = (String) lsGrilla.getItemAtPosition(position).toString();
                 mostrar(view,texto);
                AccionActualizar(view,texto);
             }
        });
    }

    public void AccionActualizar(View v,String texto){
        Intent intent = new Intent(Grilla.this,ActualizarProvincia.class);
        intent.putExtra("NombreProv", texto);
        startActivity(intent);
    }

    //Metodos
    public void CargarListado() {
        //Crear instancia para una base de datos con el nombre que sera creada
        DBHelper DbAdmin = new DBHelper (this, "MapaCovidRD.db", null, 1);
        //Obtener acceso de lectura a la base de datos
        SQLiteDatabase BaseDatos = DbAdmin.getReadableDatabase();

        try {
            Cursor fila = BaseDatos.rawQuery("select * from Casos", null);
            if (fila.moveToFirst()) {
                List<String> Lista = new ArrayList<String>();
                do{
                    Lista.add(fila.getString(1));
                } while (fila.moveToNext());
                ArrayAdapter<String> adaptor = new ArrayAdapter<String>(this, R.layout.list_item_buscar, Lista);
                lsGrilla.setAdapter(adaptor);
            } else {
                Toast.makeText(this, "No se ha podido cargar la base de datos", Toast.LENGTH_SHORT).show();
            }
            fila.close();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            BaseDatos.close();
        }
    }

    public void mostrar(View view,String texto){
        Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();
    }
}
