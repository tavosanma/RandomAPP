package cl.ubiobio.hospitallinares;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//clase principal que muestra los datos de la farmacia en una lista, para ello se utilizan las siguientes funciones que verán a continuación
public class fragmentmainfarmacias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentmainfarmacias);
        ListFragment fragment = new ListFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();//Inicia una serie de operaciones de edición en los Fragmentos asociados con este FragmentManager.
        fragmentTransaction.add(R.id.placeholder,fragment);
        fragmentTransaction.commit();
    }
}
