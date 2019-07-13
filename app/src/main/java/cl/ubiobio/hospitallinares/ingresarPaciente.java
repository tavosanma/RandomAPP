package cl.ubiobio.hospitallinares;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import cl.ubiobio.hospitallinares.Model.paciente;

public class ingresarPaciente extends AppCompatActivity implements View.OnClickListener {
    private int dia, mes, ano;
     EditText nombre, folio, rut, EditTextnacimiento;
     FirebaseDatabase firebaseDatabase;
     DatabaseReference databaseReference;
     Button ingresar,nacimiento,volver;
     Date d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_paciente);

         iniciarFireBase();
         nombre = findViewById(R.id.nombre);
         folio = findViewById(R.id.folio);
         rut= findViewById(R.id.rut);
         EditTextnacimiento = findViewById(R.id.nacimiento);
         ingresar = findViewById(R.id.ingresar);
         nacimiento = findViewById(R.id.buttonNacimiento);
         volver = findViewById(R.id.volver);
         ingresar.setOnClickListener(this);
         nacimiento.setOnClickListener(this);
         volver.setOnClickListener(this);

    }

    private void iniciarFireBase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        //firebaseDatabase.setPersistenceEnabled(true); //Percistencia de datos
        databaseReference = firebaseDatabase.getReference();
    }

    private void validacion() {
        String name = nombre.getText().toString();
        String folioo = folio.getText().toString();
        String run = rut.getText().toString();
        String fechaNac = EditTextnacimiento.getText().toString();
        if (name.equals("")){
            nombre.setError("Requerido");
        }else
            if (folioo.equals("")){
                folio.setError("Requerido");
            }
        else if (run.equals("")){
            rut.setError("Requerido");
            }
            else if (fechaNac.equals("")){
            EditTextnacimiento.setError("Requerido");
            }
    }


    @Override
    public void onClick(View view) {
        if (view == nacimiento ){
            final Calendar calendar = Calendar.getInstance();
            dia = calendar.get(Calendar.DAY_OF_MONTH);
            mes = calendar.get(Calendar.MONTH);
            ano = calendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    EditTextnacimiento.setText(dayOfMonth + "/" + (month+1) + "/" + year);

                }
            }, dia, mes, ano);
            datePickerDialog.show();
        }else if (view == volver){
            Intent intent = new Intent(ingresarPaciente.this,Menu.class);
            startActivity(intent);
        }else if (view == ingresar){
            if (nombre.getText().toString().equals("")||folio.getText().toString().equals("")||
                    EditTextnacimiento.getText().toString().equals("")|| rut.getText().toString().equals("")) {
                validacion();
            }else {
                String f = folio.getText().toString();
                int valueFolio = Integer.parseInt(f);
                String date = EditTextnacimiento.getText().toString();

                paciente paciente = new paciente();
                paciente.setUid(UUID.randomUUID().toString());
                paciente.setNombre(nombre.getText().toString());
                paciente.setFolio(valueFolio);
                paciente.setRut(rut.getText().toString());
                paciente.setNacimiento(date);
                databaseReference.child("Paciente").child(paciente.getUid()).setValue(paciente);
                Toast.makeText(getApplicationContext(), "agregado",Toast.LENGTH_SHORT).show();
                nombre.setText("");
                folio.setText("");
                rut.setText("");
                EditTextnacimiento.setText("");
                Intent intent = new Intent(ingresarPaciente.this,menubkn.class);
                startActivity(intent);
            }
        }
    }
}
