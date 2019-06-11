package cl.ubiobio.hospitallinares;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class mainfarmacias extends  AppCompatActivity{

    private ListView lvFarmacia;
    private farmaciaslistadapter adapter;
    private List<farmacias> mfarmaciasList;
    private ArrayList<Farmacia> farmaciasDeTurno;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmacialistmain);

        lvFarmacia = (ListView) findViewById(R.id.listviewfarmacias);
        mfarmaciasList = new ArrayList<>();
        farmaciasDeTurno = new ArrayList<>();
        serviceFarmacias();




    }
    private void serviceFarmacias(){
        Log.d("LOG WS", "entre");
        String WS_URL = "http://farmanet.minsal.cl/index.php/ws/getLocalesTurnos";
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest request = new StringRequest(
                Request.Method.GET,
                WS_URL,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray responseJson = new JSONArray(response);

                            for(int i = 0; i < responseJson.length(); i++){
                                JSONObject o = responseJson.getJSONObject(i);
                                Farmacia far = new Farmacia();

                                far.setFecha(o.getString("fecha"));
                                far.setLocal_id(o.getString("local_id"));
                                far.setRegion_id(o.getString("fk_region"));
                                far.setComuna_id(o.getString("fk_comuna"));
                                far.setLocalidad_id(o.getString("fk_localidad"));
                                far.setNombre_farmacia(o.getString("local_nombre"));
                                far.setNombre_comuna(o.getString("comuna_nombre"));
                                far.setDireccion_farmacia(o.getString("local_direccion"));
                                far.setHorario_apertura(o.getString("funcionamiento_hora_apertura"));
                                far.setHorario_cierre(o.getString("funcionamiento_hora_cierre"));
                                far.setTelefono(o.getString("local_telefono"));
                                String lat = o.getString("local_lat");
                                String lng = o.getString("local_lng");

                                try{
                                    far.setLatitud(Double.parseDouble(lat));
                                    far.setLongitud(Double.parseDouble(lng));
                                }catch (NumberFormatException e){
                                    far.setLatitud(0);
                                    far.setLongitud(0);
                                }

                                farmaciasDeTurno.add(far);

                            }
                            for(int i=0;i<farmaciasDeTurno.size();i++){
                                mfarmaciasList.add(new farmacias(farmaciasDeTurno.get(i).getLocal_id(),
                                        farmaciasDeTurno.get(i).getNombre_farmacia(),
                                        farmaciasDeTurno.get(i).getNombre_comuna(),
                                        farmaciasDeTurno.get(i).getDireccion_farmacia(),
                                        "Fecha: "+farmaciasDeTurno.get(i).getFecha()));
                            }
                            adapter= new farmaciaslistadapter(getApplicationContext(),mfarmaciasList);
                            lvFarmacia.setAdapter(adapter);

                            Log.d("LOG", "cantidad: " + farmaciasDeTurno.size());

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("LOG WS", error.toString());

            }
        }
        );
        requestQueue.add(request);
    }
}
