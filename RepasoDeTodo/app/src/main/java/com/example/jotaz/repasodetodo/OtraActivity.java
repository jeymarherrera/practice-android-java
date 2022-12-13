package com.example.jotaz.repasodetodo;

import android.content.Intent;
import android.security.keystore.UserPresenceUnavailableException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OtraActivity extends AppCompatActivity {

    TextView usuario, contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra);

        Intent datos = getIntent();

        this.InicializarControles();
        this.LoadDatos(datos);
    }


    private void InicializarControles(){
        usuario = (TextView)findViewById(R.id.lblUsuario);
        contrasena = (TextView)findViewById(R.id.lblContrasen);

    }

    private void LoadDatos(Intent intentEntrante){

        usuario.setText(intentEntrante.getStringExtra("Usuario"));
        contrasena.setText(intentEntrante.getStringExtra("Contrasena"));
    }
}
