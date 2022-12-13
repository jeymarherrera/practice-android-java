package com.example.taller_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class creaciondeusuario extends AppCompatActivity {
    EditText user,pass,correo,cedula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creaciondeusuario);
        inicializacionControladores();
    }

    private void inicializacionControladores() {
        user = (EditText)findViewById(R.id.txtUserR);
        pass = (EditText)findViewById(R.id.txtPassR);
        correo = (EditText)findViewById(R.id.txtCorreo);
        cedula= (EditText)findViewById(R.id.txtCedula);



        cargarRefereferencias();
    }

    private void cargarRefereferencias() {

    }

    public void InsertarUsuario(View v){
        try {
            guardarReferencias();
        }catch (Exception e){

        }
    }

    private void guardarReferencias(){
        String u = user.getText().toString();
        String p = pass.getText().toString();
        String cor = correo.getText().toString();
        String cedul = cedula.getText().toString();

            SharedPreferences prefs = getSharedPreferences("Login", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("user",u);
            editor.putString("pass",p);
            editor.putString("correo",cor);
            editor.putString("contra",cedul);
            Toast.makeText(getApplicationContext(),"Datos guardados",Toast.LENGTH_LONG).show();
            editor.commit();


    }



}