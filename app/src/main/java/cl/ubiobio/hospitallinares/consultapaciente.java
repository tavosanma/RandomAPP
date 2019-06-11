package cl.ubiobio.hospitallinares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class consultapaciente extends AppCompatActivity {
    //Iniciación de variables
    EditText rut,folio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultapaciente);

        //Encontrar los Ids de los componentes de la activity_consultapaciente
        rut= (EditText) findViewById(R.id.rut);
        folio= (EditText) findViewById(R.id.folio);
        Button botonrf=(Button) findViewById(R.id.botonrf);
        botonrf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });
    }

    //funcion que verifica si los campos están o no vacíos, mostrando un mensaje de campo obligatorio
    public void validar(){

        rut.setError(null);
        folio.setError(null);

        String Rut= rut.getText().toString();
        String Folio= folio.getText().toString();

        if (TextUtils.isEmpty(Rut)){
            rut.setError(getString(R.string.campoobligatorio));
            rut.requestFocus(); //Teclado comienza inmediatamente al iniciar la actividad
            return;
        }
        if (TextUtils.isEmpty(Folio)) {
            folio.setError(getString(R.string.campoobligatorio));
            folio.requestFocus();
            return;
        }
    }

    }


