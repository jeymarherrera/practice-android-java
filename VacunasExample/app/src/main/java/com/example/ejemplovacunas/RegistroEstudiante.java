package com.example.ejemplovacunas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejemplovacunas.Entidades.Estudiantes;

public class RegistroEstudiante extends AppCompatActivity {

    private EditText nombre, cedula, edad, telefono, correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_estudiante);
        InicializarControles();
    }

    private void InicializarControles() {
        nombre = (EditText) findViewById(R.id.txtNombre);
        cedula = (EditText) findViewById(R.id.txtCedula);
        edad = (EditText) findViewById(R.id.txtEdad);
        telefono = (EditText) findViewById(R.id.txtTelefono);
        correo = (EditText) findViewById(R.id.txtCorreo);
    }

    public void Registrar (View view){
        try {
            Estudiantes estudiante = new Estudiantes(
                    nombre.getText().toString(),
                    cedula.getText().toString(),
                    Integer.parseInt(edad.getText().toString()),
                    telefono.getText().toString(),
                    correo.getText().toString()
            );
            Boolean registrado = estudiante.insert(getApplicationContext());
            if (registrado){
                Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
            }else {
                Toast.makeText(this, "Error al Registrar", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(this, "ERROR: "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}