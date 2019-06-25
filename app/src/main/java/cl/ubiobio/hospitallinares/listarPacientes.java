package cl.ubiobio.hospitallinares;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import cl.ubiobio.hospitallinares.Model.paciente;

public class listarPacientes extends AppCompatActivity {

    private List<paciente> pacientes = new ArrayList<paciente>();
    ArrayAdapter<paciente> arrayAdapter;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ListView listView;

    paciente pacienteSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rud_pacientes);
        listView= findViewById(R.id.listview);


        iniciarFireBase();
        listarPaciente();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pacienteSelected = (paciente) adapterView.getItemAtPosition(i);
                String nombre, rut, fecha, id;
                int folio;
                nombre = pacienteSelected.getNombre();
                id = pacienteSelected.getUid();
                rut = pacienteSelected.getRut();
                folio = pacienteSelected.getFolio();
                fecha = pacienteSelected.getNacimiento();
                Intent intent = new Intent(listarPacientes.this, UpdateAndDeletePaciente.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("id",id);
                intent.putExtra("rut",rut);
                intent.putExtra("folio",folio);
                intent.putExtra("fecha",fecha);
                startActivity(intent);

            }
        });
    }

    private void listarPaciente() {
        databaseReference.child("Paciente").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pacientes.clear();
                for (DataSnapshot objDataSnap : dataSnapshot.getChildren()){

                    paciente paciente = objDataSnap.getValue(paciente.class);
                    pacientes.add(paciente);
                    arrayAdapter = new ArrayAdapter<paciente>(listarPacientes.this,android.R.layout.simple_list_item_1,pacientes);
                    listView.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void iniciarFireBase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    }
}
