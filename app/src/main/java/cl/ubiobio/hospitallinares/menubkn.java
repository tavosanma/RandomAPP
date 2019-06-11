package cl.ubiobio.hospitallinares;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

//menu principal que muestra la interfaz de la ventana principal, la cual los usuarios interactuarán a traves de imagenesButtons
//Menu con interfaz para las personas con habilidad para usar el celular
public class menubkn extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,fragmentconsultapaciente.OnFragmentInteractionListener,consultahorafragment.OnFragmentInteractionListener,horariovisitafragment.OnFragmentInteractionListener,fragmentlistfarmacias.OnFragmentInteractionListener,donasangrefragment.OnFragmentInteractionListener,carteradeserviciosfragment.OnFragmentInteractionListener,saludrespondefragment.OnFragmentInteractionListener{
        /*menú dentro del modo de visualización dinámico*/
        /*las actividades llamadas por uso de fragment son distintas a aquellas que no lo son, respectivamente*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menubkn);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //Los items del navigationsDrawer se trabajan con ids, por lo mismo debemos obtenerlas
        int id = item.getItemId();

        Fragment fragment=null;
        Boolean fragmentoSeleccionado=false;
        //Al momento de clickear un item del navigationDrawer, se nos instanciarán a diferentes actividades
        if (id == R.id.consultpacient) {
            fragment= new fragmentconsultapaciente();
            fragmentoSeleccionado=true;/*se invoca a la clase fragmentconsultapaciente*/
        } else if (id == R.id.consulthora) {
            fragment= new consultahorafragment();/*se invoca a la clase consultahorafragment*/
            fragmentoSeleccionado=true;

        } else if (id == R.id.horariovisit) {
            fragment= new horariovisitafragment();/*se invoca a la clase consultahorafragment*/
            fragmentoSeleccionado=true;

        } else if (id == R.id.farmacias) {
            fragment= new fragmentlistfarmacias();/*se invoca a la clase fragmentlistfarmacias*/
            fragmentoSeleccionado=true;

        } else if (id == R.id.donasangre) {
            fragment= new donasangrefragment();/*se invoca a la clase donasangrefragment*/
            fragmentoSeleccionado=true;


        } else if (id == R.id.carteraservicios) {
            fragment= new carteradeserviciosfragment();/*se invoca a la clase carteradeserviciosfragment*/
            fragmentoSeleccionado=true;

        } else if (id == R.id.sldresp) {
            fragment = new saludrespondefragment();/*se invoca a la clase saludrespondefragment*/
            fragmentoSeleccionado = true;
        }else if (id == R.id.mapaHospital) {
                Intent IntentLoadNewActivity= new Intent(getApplicationContext(),mapaHospital.class);
                startActivity(IntentLoadNewActivity); // Muestra  GoogleMap con algunos hospitales

        } else if (id == R.id.cambiarsesion) {
            Intent IntentLoadNewActivity = new Intent(getApplicationContext(), Menu.class);/*cambia el modo de visualización de dinámico a simple, invoca a la clase Menu*/
            startActivity(IntentLoadNewActivity);
        }

        if(fragmentoSeleccionado){

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragment).commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());


        }
        /*al seleccionar una opción del modo dinámico, excepto el cambiar modo de vista, se redirige a la respectiva actividad con fragment*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
