
package cl.ubiobio.hospitallinares;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Inicio extends AppCompatActivity {
    /*Esta clase llama al splash screen y muestra una ventana con opciones de visualización*/



    private Inicio _this=this;
    private SharedPreferences sharedPre;
    private SharedPreferences.Editor editorSP;
    private int NO_PREFERENCES = 0;/*sin preferencia de visualización*/
    private int Admin=1;/*modo de visualización dinámico, nombre de la variable sujeta a cambio*/
    private int MODO_VIEJO=2;/*modo de visualización simple, nombre de la variable sujeta a cambio*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);/*invoca a la actividad activity_inicio, correspondiente al splash screen*/


        sharedPre= getSharedPreferences(getString(R.string.sharedPreID),MODE_PRIVATE);
        editorSP=sharedPre.edit();
        Handler handler= new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                /*se llama la alerta y se indica qué modo de visualización se seleccionará, al asignar el valor de MODO_JOVEN o MODO_VIEJO a MODO*/
                Intent iniciar;
                if (sharedPre.getInt("MODO",NO_PREFERENCES)== NO_PREFERENCES){
                    AlertDialog.Builder alertBuilder= new AlertDialog.Builder(_this);/*genera la alerta que permite seleccionar modo de visualización*/
                    alertBuilder.setMessage("Elija el modo").setTitle("Seleccionar tipo de Interfaz").setPositiveButton("MODO Administrador", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            editorSP.putInt("MODO",Admin);
                            editorSP.commit();
                            Intent iniciar= new Intent(_this, menubkn.class);
                            startActivity(iniciar);
                            finish();
                        }
                    }).setNegativeButton("MODO SIMPLE", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            editorSP.putInt("MODO",MODO_VIEJO);
                            editorSP.commit();
                            Intent iniciar= new Intent(_this, Menu.class);
                            startActivity(iniciar);
                            finish();
                        }
                    });
                    AlertDialog dialog=alertBuilder.create();
                    dialog.show();

                }else{
                    /*en la alerta, el boton correspondiente a la opción "sí", invoca a la clase menubkn, correspondiente al modo dinámico*/
                    /*en la alerta, el boton correspondiente a la opción "no", invoca a la clase Menu, correspondiente al modo dinámico*/

                    if (sharedPre.getInt("MODO",NO_PREFERENCES)==Admin){
                        iniciar=new Intent(_this,menubkn.class);

                    }else{
                        iniciar= new Intent(_this,Menu.class);
                    }
                    startActivity(iniciar);
                    finish();
                }

            }

        }, 2000);
    }


}

