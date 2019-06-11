package cl.ubiobio.hospitallinares;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

//Clase que se necesita para mostrar mediante una lista(ListView) los diferentes datos que posee una farmacia
public class farmaciaslistadapter extends BaseAdapter {
    //Iniciación de variables
    private Context mContext;
    private List<farmacias> mfarmaciaslist;

    public farmaciaslistadapter(Context mContext, List<farmacias> mfarmaciaslist) {
        this.mContext = mContext;
        this.mfarmaciaslist = mfarmaciaslist;
    }
    //Obtener el tamaño,id y posición de los items de la lista farmacia
    @Override
    public int getCount() {
        return mfarmaciaslist.size();
    }
    @Override
    public Object getItem(int position) {
        return mfarmaciaslist.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    //Obtendremos los ids de los datos de las farmacias
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v= View.inflate(mContext,R.layout.farmaciaitemslist,null); //Clase que usa el metodo inflater para crear y añadir la vista de la actividad fragmetn_carteraserviciosfragment
        TextView tvName= (TextView) v.findViewById(R.id.nombrefarmacia);
        TextView tvCiudad= (TextView) v.findViewById(R.id.ciudadfarmacia);
        TextView tvDireccion= (TextView) v.findViewById(R.id.direccionfarmacia);
        TextView tvHorario= (TextView) v.findViewById(R.id.horariofarmacia);

        //establecer los datos de las farmacias en textos para mostrarlos en una lista , la cual necesitamos de la posición e id
        tvName.setText(mfarmaciaslist.get(position).getNombrefarmacia());
        tvCiudad.setText(mfarmaciaslist.get(position).getCiudadfarmacia());
        tvDireccion.setText(mfarmaciaslist.get(position).getDireccionfarmacia());
        tvHorario.setText(mfarmaciaslist.get(position).getHorariofarmacia());

        v.setTag(mfarmaciaslist.get(position).getId());

        return v;
    }
}
