package com.example.parcial2v5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class ProfileActivity extends AppCompatActivity {
    EditText nombre;
    RadioButton sitioestudiante,sitioestudioantesiu,sitioprofesor;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        iniciarlizarcontroles();
    }

    private void iniciarlizarcontroles() {

        sitioestudiante = (RadioButton) findViewById(R.id.sitioestudiante);
        sitioestudioantesiu = (RadioButton) findViewById(R.id.sitioestudiantesiu);
        sitioprofesor= (RadioButton) findViewById(R.id.sitioprofesor);
        nombre = (EditText) findViewById((R.id.NombreUser));

    }




    public void SitioBusc(View view ){
        SharedPreferences preferencias = getSharedPreferences("usuario",MODE_PRIVATE);

        if (sitioprofesor.isChecked()){

            //  startActivity(new Intent(getApplicationContext(),RegistroActivity.class));


            SharedPreferences.Editor editor = preferencias.edit();
            editor.putString("tipo","0");
            editor.commit();
            startActivity(new Intent(getApplicationContext(),PantallaMaterias.class));
        }

        else if (sitioestudiante.isChecked()){

            //   startActivity(new Intent(getApplicationContext(),RegistroActivity.class));


            SharedPreferences.Editor editor = preferencias.edit();
            editor.putString("tipo","1");
            editor.commit();
            startActivity(new Intent(getApplicationContext(),PantallaMaterias.class));
        }

        else if ( sitioestudioantesiu.isChecked()){

            url="http://utp.ac.pa";

            Uri uri = Uri.parse(url);

            Intent intent = new Intent(Intent.ACTION_VIEW, uri);

            startActivity(intent);

        }

    }
}