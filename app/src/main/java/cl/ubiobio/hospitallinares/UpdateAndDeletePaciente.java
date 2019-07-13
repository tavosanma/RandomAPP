package cl.ubiobio.hospitallinares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import cl.ubiobio.hospitallinares.Model.paciente;

public class UpdateAndDeletePaciente extends AppCompatActivity {

    EditText nombre, folio, rut, fecha;
    String id;
    Button volver, actualizar, borrar;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_and_delete_paciente);
        iniciarFireBase();
        nombre = findViewById(R.id.nombreUPDE);
        folio = findViewById(R.id.folioUPDE);
        rut = findViewById(R.id.rutUPDE);
        fecha = findViewById(R.id.fechaUPDE);
        volver = findViewById(R.id.atras);
        actualizar = findViewById(R.id.actualizar);
        borrar = findViewById(R.id.borrar);

        Intent mIntent = getIntent();

        nombre.setText(mIntent.getStringExtra("nombre"));
        rut.setText(mIntent.getStringExtra("rut"));
        folio.setText(Integer.toString(mIntent.getIntExtra("folio", 0)));
        fecha.setText(mIntent.getStringExtra("fecha"));
        id = mIntent.getStringExtra("id");

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateAndDeletePaciente.this, listarPacientes.class);
                startActivity(intent);
                finish();
            }
        });
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f = folio.getText().toString().trim();
                int valueFolio = Integer.parseInt(f);
                paciente paciente = new paciente();
                paciente.setUid(id);
                paciente.setNombre(nombre.getText().toString().trim());
                paciente.setRut(rut.getText().toString().trim());
                paciente.setFolio(valueFolio);
                paciente.setNacimiento(fecha.getText().toString().trim());
                databaseReference.child("Paciente").child(paciente.getUid()).setValue(paciente);
                Toast.makeText(getApplicationContext(),"Actualizado",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(UpdateAndDeletePaciente.this, listarPacientes.class);
                startActivity(intent);
                finish();

            }
        });
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paciente paciente = new paciente();
                paciente.setUid(id);
                databaseReference.child("Paciente").child(paciente.getUid()).removeValue();
                Toast.makeText(getApplicationContext(),"Eliminado",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(UpdateAndDeletePaciente.this, listarPacientes.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void iniciarFireBase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}
