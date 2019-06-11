package cl.ubiobio.hospitallinares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

//menu principal que muestra la interfaz de la ventana principal, la cual los usuarios interactuarán a traves de imagenesButtons
//Menu con interfaz para las personas de la tercera edad
public class Menu extends AppCompatActivity {

    //Iniciacilizacón de botonesImagenes
    ImageButton imgb1;
    ImageButton imgb2;
    ImageButton imgb3;
    ImageButton imgb4;
    ImageButton imgb5;
    ImageButton imgb6;
    ImageButton imgb7;
    ImageButton imgb8;
    ImageButton imgb9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //Encontramos sus IDs
        imgb1= (ImageButton) findViewById(R.id.horariovisitas);
        imgb2= (ImageButton) findViewById(R.id.consultamedica);
        imgb3= (ImageButton) findViewById(R.id.consultapaciente);
        imgb4= (ImageButton) findViewById(R.id.saludresponde);
        imgb5= (ImageButton) findViewById(R.id.carteraservicios);
        imgb6= (ImageButton) findViewById(R.id.farmaciaturno);
        imgb7= (ImageButton) findViewById(R.id.donasangre);
        imgb8 = (ImageButton) findViewById(R.id.botonmapa);
        imgb9= (ImageButton) findViewById(R.id.cambiarsesion);

        //Al clickear en las imagenes, nos instancia a diferentes clases con diferentes actividades cada una
        imgb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentLoadNewActivity= new Intent(Menu.this,Horariovisita.class);
                startActivity(IntentLoadNewActivity);
            }
        });
        imgb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentLoadNewActivity= new Intent(Menu.this,consultahora.class);
                startActivity(IntentLoadNewActivity);
            }
        });
        imgb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentLoadNewActivity= new Intent(Menu.this,consultapaciente.class);
                startActivity(IntentLoadNewActivity);
            }
        });
        imgb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentLoadNewActivity= new Intent(Menu.this,saludresponde.class);
                startActivity(IntentLoadNewActivity);
            }
        });
        imgb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentLoadNewActivity= new Intent(Menu.this,carteradeservicios.class);
                startActivity(IntentLoadNewActivity);
            }
        });
        imgb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentLoadNewActivity= new Intent(Menu.this,mainfarmacias.class);
                startActivity(IntentLoadNewActivity);
            }
        });
        imgb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentLoadNewActivity= new Intent(Menu.this,donasangre.class);
                startActivity(IntentLoadNewActivity);
            }
        });
        imgb8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntenLoadNewActivity= new Intent(Menu.this,mapaHospital.class);
                startActivity(IntenLoadNewActivity);
            }
        });
        imgb9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentLoadNewActivity= new Intent(Menu.this,menubkn.class);
                startActivity(IntentLoadNewActivity);
            }
        });

    }
}
