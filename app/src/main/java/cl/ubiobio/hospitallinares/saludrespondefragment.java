package cl.ubiobio.hospitallinares;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link saludrespondefragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link saludrespondefragment#newInstance} factory method to
 * create an instance of this fragment.
 */
// Clase que se extiende de un fragmento, el cual es necesario para que las clases puedan funcionar usando navigationDrawer
// Cabe señalar que métodos no comentados son debido a que vienen por defecto al crear una clase que se extiende de un fragmento
public class saludrespondefragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private boolean toastspin1=true;
    private boolean toastspin2=true;

    public saludrespondefragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment saludrespondefragment.
     */
    // TODO: Rename and change types and number of parameters
    public static saludrespondefragment newInstance(String param1, String param2) {
        saludrespondefragment fragment = new saludrespondefragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    //Clase que usa el metodo inflater para crear y añadir la vista de la actividad fragment_saludrespondefragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_saludrespondefragment, container, false);
        //busqueda y guardado de Ids de los botones de la clase fragmento
        final EditText rut= (EditText) v.findViewById(R.id.rut);
        final EditText nombre= (EditText) v.findViewById(R.id.nombre);
        final EditText email= (EditText) v.findViewById(R.id.email);
        final EditText telofono= (EditText) v.findViewById(R.id.telefono);


        Spinner tipotelefono= (Spinner)v.findViewById(R.id.spiner1);
        Spinner codigotelefono= (Spinner) v.findViewById(R.id.spiner2);
        //Arrays que guardan las diferentes opciones que tendrá un componente spiner
        ArrayAdapter<CharSequence> adapter1= ArrayAdapter.createFromResource(getContext(),R.array.tipotelefono,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2= ArrayAdapter.createFromResource(getContext(),R.array.codigotelefono,android.R.layout.simple_spinner_item);

        tipotelefono.setAdapter(adapter1);
        codigotelefono.setAdapter(adapter2);

        tipotelefono.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            //al clikear en el spin, nos saldra un mensaje en formato Toast de lo que se ha seleccionado en ese momento
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(toastspin1){
                    toastspin1=false;
                }else{
                    Toast.makeText(parent.getContext(),"SELECCIÓN:"+ parent.getItemAtPosition(position).toString() ,Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            //Si no se ha seleccionado algo en el spinner mostrar algun mensaje....
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        codigotelefono.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            //al clikear en el spin, nos saldra un mensaje en formato Toast de lo que se ha seleccionado en ese momento
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

        /*Validar que los campos estén completados con información ,para que no se lanze un mensaje de
          campo obligatorio cuando se clickee en el boton correspondiente*/
        Button botonsalud=(Button) v.findViewById(R.id.botonsalud);
        botonsalud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
            public void validar(){
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
        return v;
    }





    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
