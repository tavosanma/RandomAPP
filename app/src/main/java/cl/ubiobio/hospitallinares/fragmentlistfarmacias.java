package cl.ubiobio.hospitallinares;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//Clase que me permite mostrar una lista de elementos basado en en largo de los conjuntos, usando listAdapter y RecyclerView
public class fragmentlistfarmacias extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragmentlist,container,false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewList); //Encontramos su id
        ListAdapter listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);//Establecemos la listaAdapter al recylcerView
        //Agregando la lista a nuestro actividad layout el cual mostraremos a traves de las clases, mostrandos en forma de linear layout
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    public interface OnFragmentInteractionListener {
    }
}
