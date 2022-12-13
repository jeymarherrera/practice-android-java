package com.example.supercovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.supercovid.Entidades.Estudiantes;

public class RegistroEstudianteActivity extends AppCompatActivity {

    private EditText nombre,cedula,edad,telefono,correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_estudiante);

        InicializarControler();
    }

    private void InicializarControler() {
        nombre = (EditText)findViewById(R.id.txtNombre);
        cedula = (EditText)findViewById(R.id.txtCedula);
        edad = (EditText)findViewById(R.id.txtEdad);
        telefono = (EditText)findViewById(R.id.txtTelefono);
        correo = (EditText)findViewById(R.id.txtCorreo);
    }

    public void Registrar(View v){
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
                Toast.makeText(this,"Woooeee, se inserto",Toast.LENGTH_LONG).show();
                startActivity(new Intent(this,MainActivity.class));
            }else{
                Toast.makeText(this,"Ya valio y no inserto :(",Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Toast.makeText(this,"Errorcito en Registro =>"+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    
}