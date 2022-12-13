package com.example.Lab_5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taller_1.Credenciales;
import com.example.taller_1.Dialogs.Alerta;
import com.example.taller_1.R;

public class MainActivity extends AppCompatActivity {
     EditText txtNum1,txtNum2;
     RadioButton Button1,Button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InicializarControles();
    }


    private void InicializarControles(){
        txtNum1 = (EditText)findViewById(R.id.txtNum1);
        txtNum2 = (EditText)findViewById(R.id.txtNum2);





    }


    public void Login(View vista){
        try {
            int num1, num2, res=0, ope;
            String nombre ,pass,pass2="1234",mesage;


            nombre=txtNum1.getText().toString();
            pass=txtNum2.getText().toString();
            if (pass.equals(pass2) && nombre.equals("guillermo") ) {

                    mesage="a ingresado de forma exitosa estudiante";

                     startActivity(new Intent(this, Credenciales.class));


                Alerta alerta = new Alerta(mesage);
                alerta.show(getSupportFragmentManager(), "tag");

            }else{
                mesage="error en el login";
                Alerta alerta = new Alerta(mesage);
                alerta.show(getSupportFragmentManager(), "tag");

            }
        }catch (Exception e){
            Toast.makeText(this, "Error" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }





}