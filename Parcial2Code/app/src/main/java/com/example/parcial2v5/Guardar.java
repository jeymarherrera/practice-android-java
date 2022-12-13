package com.example.parcial2v5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Guardar extends AppCompatActivity {
    EditText mat1,mat2,mat3,mat4,mat5,mat6,mat7,mat8,mat9,mat10;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar);
        btn = findViewById(R.id.btngua);
        mat1 = findViewById(R.id.mate);
        mat2 = findViewById(R.id.ciencias);
        mat3 = findViewById(R.id.geografia);
        mat4 = findViewById(R.id.calculo);

        //Corregir
        mat5 = findViewById(R.id.tecnoloia);
        mat6 = findViewById(R.id.ingles);
        mat7 = findViewById(R.id.religion);
        mat8 = findViewById(R.id.fisica);
        mat9 = findViewById(R.id.filosofia);
        mat10 = findViewById(R.id.matematica2);
        Validacion();

    }

    private boolean Validacion() {





        if (mat1.length()==0 || mat2.length()==0 || mat3.length()==0 || mat4.length()==0 || mat5.length()==0 || mat6.length()==0 ||  mat7.length()==0 || mat8.length()==0 || mat9.length()==0 || mat10.length()==0) {

            Toast.makeText(getApplicationContext(),"Todos los campos deben estas llenos",Toast.LENGTH_LONG).show();

        }else if (mat1.length()==1 && mat2.length()==1 &&mat3.length()==1 && mat4.length()==1 && mat5.length()==1 && mat6.length()==1 && mat7.length()==1 &&mat8.length()==1 && mat9.length()==1 && mat10.length()==1){


     return true;
 }



        return false;

    }


    public void guardarnota(View view) {
        
        
        if (Validacion() ) {


            SharedPreferences preferencias = getSharedPreferences("usuario", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferencias.edit();
            editor.putString("nota1", mat1.getText().toString());
            editor.putString("nota2", mat2.getText().toString());
            editor.putString("nota3", mat3.getText().toString());
            editor.putString("nota4", mat4.getText().toString());
            editor.putString("nota5", mat5.getText().toString());
            editor.putString("nota6", mat6.getText().toString());
            editor.putString("nota7", mat7.getText().toString());
            editor.putString("nota8", mat8.getText().toString());
            editor.putString("nota9", mat9.getText().toString());
            editor.putString("nota10", mat10.getText().toString());
            editor.commit();
            Toast.makeText(getApplicationContext(),"Los datos se guardaron",Toast.LENGTH_LONG).show();
        }else{

            Toast.makeText(getApplicationContext(),"ERROR SOLO SE ADMITE UN CARACTER ",Toast.LENGTH_LONG).show();
        }


        //startActivity(new Intent(getApplicationContext(),PantallaMaterias.class));
    }







}