package cl.ubiobio.hospitallinares;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//CLase para mostrar mediante un recyclerView la lista con los datos almacenados
public class ListAdapter extends RecyclerView.Adapter {


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragmentlistitems,parent,false);
        return new ListViewHolder(view);
        //Se crea la vista el cual me lo retornará finalemnte , mostrando los items que hay en fragmentlistitems
    }

    @Override
    //Llama al RecyclerView para mostrar los datos a la posición especificada
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder)holder).bindView(position);

    }

    @Override
    //Retorna el numero de items
    public int getItemCount() {
        return fragmentdatosfarmacias.ciudadFarmacia.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //textviews que mostraran la informacion de la lista
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private TextView textView4;

        public ListViewHolder(View itemView){
            super(itemView);
            //Encontramos los ids de los views en la actividad layout
            textView1 = (TextView) itemView.findViewById(R.id.nombrefarmacia);
            textView2 = (TextView) itemView.findViewById(R.id.ciudadfarmacia);
            textView3 = (TextView) itemView.findViewById(R.id.direccionfarmacia);
            textView4 = (TextView) itemView.findViewById(R.id.horariofarmacia);
            itemView.setOnClickListener(this);
        }
        //Actualiza el contendio del recyclerView con los items dada la posición
        public void bindView(int position){
            textView1.setText(fragmentdatosfarmacias.nombreFarmacia[position]);
            textView2.setText(fragmentdatosfarmacias.ciudadFarmacia[position]);
            textView3.setText(fragmentdatosfarmacias.direccionFarmacia[position]);
            textView4.setText(fragmentdatosfarmacias.horaTurnoFarmacia[position]);
        }


        public void onClick(View v) {

        }
    }
}

