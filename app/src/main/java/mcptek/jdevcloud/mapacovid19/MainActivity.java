package mcptek.jdevcloud.mapacovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bReportar, bVerMapa, bAcercaDe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bReportar = findViewById(R.id.ReportarBTN);
        bVerMapa = findViewById(R.id.VerMapaBTN);
        bAcercaDe = findViewById(R.id.InfoBTN);

        bReportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccionReporte(v);
            }
        });

        bVerMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccionMAPA(v);
            }
        });

        bAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccionInfo(v);
            }
        });
    }


    public void AccionReporte(View v){
        Intent intent = new Intent(MainActivity.this,Grilla.class);
        intent.putExtra("ValorFila", 1);
        startActivity(intent);
    }

    public void AccionMAPA(View v){
        Intent intent = new Intent(MainActivity.this,MapsActivity.class);
        startActivity(intent);
    }

    public void AccionInfo(View v){
        Intent intent = new Intent(MainActivity.this,AcercaDe.class);
        startActivity(intent);
    }
}