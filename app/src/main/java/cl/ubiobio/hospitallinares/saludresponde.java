package cl.ubiobio.hospitallinares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class saludresponde extends AppCompatActivity {

    //Iniciación de variables
    EditText rut;
    EditText nombre;
    EditText telofono;
    EditText email;
    private boolean toastspin1=true;
    private boolean toastspin2=true;
    Spinner tipotelefono;
    Spinner codigotelefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludresponde);
        //Encontramos los ids de los diferentes componentes de android
        rut= (EditText) findViewById(R.id.rut);
        nombre= (EditText) findViewById(R.id.nombre);
        email= (EditText) findViewById(R.id.email);
        telofono= (EditText) findViewById(R.id.telefono);
        Button botonsalud=(Button) findViewById(R.id.botonsalud);
        botonsalud.setOnClickListener(new View.OnClickListener() {

            /*Validar que los campos estén completados con información ,para que no se lanze un mensaje de
                campo obligatorio cuando se clickee en el boton correspondiente*/
            @Override
            public void onClick(View v) {
                validar();
            }
            public void validar() {
                rut.setError(null);
                nombre.setError(null);
                telofono.setError(null);
                email.setError(null);
                //Obtener y transformar los datos en string
                String Rut= rut.getText().toString();
                String Nombre= nombre.getText().toString();
                String Telefono= telofono.getText().toString();
                String Email= email.getText().toString();


                if (TextUtils.isEmpty(Rut)){
                    rut.setError(getString(R.string.campoobligatorio));
                    rut.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(Nombre)){
                    nombre.setError(getString(R.string.campoobligatorio));
                    nombre.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(Telefono)){
                    telofono.setError(getString(R.string.campoobligatorio));
                    telofono.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(Email)){
                    email.setError(getString(R.string.campoobligatorio));
                    email.requestFocus();
                    return;
                }

            }
        });
        //Componente spiner que permite selecionar más de una opción
        tipotelefono= (Spinner)findViewById(R.id.spiner1);
        codigotelefono= (Spinner) findViewById(R.id.spiner2);

        //Arrays que guardan las diferentes opciones que tendrá un componente spiner
        ArrayAdapter<CharSequence> adapter1= ArrayAdapter.createFromResource(this,R.array.tipotelefono,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2= ArrayAdapter.createFromResource(this,R.array.codigotelefono,android.R.layout.simple_spinner_item);

       tipotelefono.setAdapter(adapter1);
       codigotelefono.setAdapter(adapter2);

       //al clikear en el spin, nos saldra un mensaje en formato Toast de lo que se ha seleccionado en ese momento
       tipotelefono.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               if(toastspin1){
                   toastspin1=false;
               }else{
                   Toast.makeText(parent.getContext(),"SELECCIÓN:"+ parent.getItemAtPosition(position).toString() ,Toast.LENGTH_SHORT).show();
               }

           }
            //Si no se ha seleccionado algo en el spinner mostrar algun mensaje....
           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
        //al clikear en el spin, nos saldra un mensaje en formato Toast de lo que se ha seleccionado en ese momento
       codigotelefono.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               if(toastspin2){
                   toastspin2=false;
               }else{
                   Toast.makeText(parent.getContext(),"SELECCIÓN:"+ parent.getItemAtPosition(position).toString() ,Toast.LENGTH_SHORT).show();
               }

           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
    }

}
