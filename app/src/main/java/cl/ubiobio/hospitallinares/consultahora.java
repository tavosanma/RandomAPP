package cl.ubiobio.hospitallinares;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class consultahora extends AppCompatActivity {
    //iniciación de variables
    EditText text;
    private consultahora _this=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultahora);
        text = findViewById(R.id.rut);  // encontrar el id del texto
        Button botonrut=(Button) findViewById(R.id.botonrut); //encontrar el id del boton

        /*Metodo que funciona al momento de hacer click en un botón, el cual en este caso iniciará la clase ListaHrs
            cuando el metodo validar sea verdadero*/
        botonrut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(validar()){
                Intent intent = new Intent(_this, ListaHrs.class);
                intent.putExtra("Valor", text.getText());  // valor que se guardará aun después de cambiar de activity
                startActivity(intent);
            }
            }
        });
    }

    //Funcion que verifica que el campo text no sea vacío, arrojando un mensaje en caso contrario|
    public boolean validar(){

        text.setError(null);

        String Rut= text.getText().toString();

        if (TextUtils.isEmpty(Rut)){
            text.setError(getString(R.string.campoobligatorio));
            return false;
    }
    return true;
  }

}


