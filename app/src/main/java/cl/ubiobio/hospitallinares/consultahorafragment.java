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
 * {@link consultahorafragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link consultahorafragment#newInstance} factory method to
 * create an instance of this fragment.
 */

// Clase que se extiende de un fragmento, el cual es necesario para que las clases puedan funcionar usando navigationDrawer
// Cabe señalar que métodos no comentados son debido a que vienen por defecto al crear una clase que se extiende de un fragmento
public class consultahorafragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public consultahorafragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment consultahorafragment.
     */
    // TODO: Rename and change types and number of parameters
    public static consultahorafragment newInstance(String param1, String param2) {
        consultahorafragment fragment = new consultahorafragment();
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
    //Clase que usa el metodo inflater para crear y añadir la vista de la actividad fragmetn_carteraserviciosfragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_consultahorafragment, container, false);
        final EditText rut= (EditText) v.findViewById(R.id.rut); //Se usa final cuando se trabaja con fragments
        Button botonrut =(Button) v.findViewById(R.id.botonrut);//Busca la id del boton

        /*Metodo que funciona al clickear un boton el cual valida si un campo
            está vacio o no , enviando un mensaje correspondiente si así lo fuese.
         */
        botonrut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
            public void validar(){

                rut.setError(null);

                String Rut= rut.getText().toString();

                if (TextUtils.isEmpty(Rut)){
                    rut.setError(getString(R.string.campoobligatorio));
                    rut.requestFocus(); //Insertar datos inmediatamente al iniciar la clase
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
