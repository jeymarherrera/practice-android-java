package com.example.taller_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Credenciales extends AppCompatActivity {
//---------------------------------------------------------------------------------------------------------//
//--------------------------------------------VARIABLES TIPO ANDROID GLOBALES-------------------------//
TextView user,cedula,grupo,tema;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credenciales);

        inicializacionControladores();

    }

    private void inicializacionControladores() {
    String nombre="guillermo ", grupo4="isl-131", tema4="Laboratorio5",cedula4="8-959-2011";
        user = (TextView) findViewById(R.id.txtUserrio);
        cedula = (TextView)findViewById(R.id.txtcedula);
        grupo = (TextView)findViewById(R.id.txtgrupo);
       tema = (TextView)findViewById(R.id.txttema);


       user.setText(nombre);
       cedula.setText(cedula4);
        grupo.setText(grupo4);
       tema.setText(tema4);
    }




//---------------------------------------------------------------------------------------------------------//
//--------------------------------------------OPCION PARA MOSTRA EL  MENU DE BARRA-------------------------//

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.newItem:
                Toast.makeText(this,"Selecciono el menu", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, creaciondeusuario.class));
                break;
            default:
                return true;
        };

        return true;
    }
}