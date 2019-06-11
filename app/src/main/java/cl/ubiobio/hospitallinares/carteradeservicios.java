package cl.ubiobio.hospitallinares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class carteradeservicios extends AppCompatActivity {
    /*crea 4 botones en la clase, que son los que se asocian a 4 actividades distintas*/
    Button b1;
    Button b2;
    Button b3;
    Button b4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carteradeservicios);/*invoca la actividad carteradeservicios*/
        /*busca y almacena el id de los  botones de la clase carteradeserviciod*/
        b1= (Button) findViewById(R.id.botonatencionabierta);
        b2= (Button) findViewById(R.id.botonatencionurgencia);
        b3= (Button) findViewById(R.id.botonatencioncerrada);
        b4= (Button) findViewById(R.id.botonapoyoclinico);

        // metodo que manda a llamar las diferenes actividades al momento de clickear en un botón
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentLoadNewActivity= new Intent(carteradeservicios.this,atencionabierta.class);
                startActivity(IntentLoadNewActivity);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentLoadNewActivity= new Intent(carteradeservicios.this,atencionurgencia.class);
                startActivity(IntentLoadNewActivity);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentLoadNewActivity= new Intent(carteradeservicios.this,atencioncerrada.class);
                startActivity(IntentLoadNewActivity);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentLoadNewActivity= new Intent(carteradeservicios.this,apoyoclinico.class);
                startActivity(IntentLoadNewActivity);
            }
        });
    }
}
