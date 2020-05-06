package mcptek.jdevcloud.mapacovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActualizarProvincia extends AppCompatActivity {

    private Button bGuardar;
    private EditText etValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_provincia);

        bGuardar =  findViewById(R.id.GuardarBTN);
        etValor = findViewById(R.id.ValorTXT);

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Guardar();
            }
        });
    }

    public void mostrar(String texto){
        Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();
    }

    private void Guardar(){
        DBHelper dbAdmin = new DBHelper(this,"MapaCovidRD.db",null,1);
        SQLiteDatabase BaseDatos = dbAdmin.getWritableDatabase();
        String NombreProv = getIntent().getExtras().getString("NombreProv");
        int Valor = Integer.parseInt(etValor.getText().toString());

        String val = String.valueOf(Valor);
        mostrar(NombreProv);
        mostrar(val);

        if (!NombreProv.isEmpty()) {
            ContentValues registro = new ContentValues();
            registro.put("Provincia",NombreProv);
            registro.put("TotalProvincial",Valor);

            String[] argumento = new String[1];
            argumento[0]=NombreProv;
            BaseDatos.update("Casos",registro,"Provincia =? ",argumento);

            Toast.makeText(this, "Total actualizado", Toast.LENGTH_SHORT).show();

            BaseDatos.close();

            Limpiar();

            Toast.makeText(this,"Registro guardado",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"Favor llenar los campos",Toast.LENGTH_LONG).show();
        }
    }

    private void Limpiar(){
        etValor.setText("");
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}