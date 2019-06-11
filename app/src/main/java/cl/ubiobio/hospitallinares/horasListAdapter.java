package cl.ubiobio.hospitallinares;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

//Clase que se necesita para mostrar mediante una lista(ListView) los diferentes datos que posee una farmacia
public class horasListAdapter extends BaseAdapter{
    //Iniciación de variables
    private Context mContext;
    private List<Hora> mfarmaciaslist;
    public horasListAdapter(Context mContext, List<Hora> mfarmaciaslist) {
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
        View v= View.inflate(mContext,R.layout.content_lista_hrs,null);
        TextView tvName= (TextView) v.findViewById(R.id.nombrePaciente);
        TextView tvCiudad= (TextView) v.findViewById(R.id.fecha);
        TextView tvDireccion= (TextView) v.findViewById(R.id.doc);
        TextView tvHorario= (TextView) v.findViewById(R.id.areadoc);
        TextView tvUbicacion=v.findViewById(R.id.nombrePaciente);
        //establecer los datos de las farmacias en textos para mostrarlos en una lista , la cual necesitamos de la posición e id
        tvName.setText(mfarmaciaslist.get(position).getPaciente());
        tvCiudad.setText(mfarmaciaslist.get(position).getFecha());
        tvDireccion.setText(mfarmaciaslist.get(position).getDoc());
        tvHorario.setText(mfarmaciaslist.get(position).getArea());
        tvUbicacion.setText(mfarmaciaslist.get(position).getUbicacion());

        v.setTag(mfarmaciaslist.get(position).getId() );

        return v;
    }
}


