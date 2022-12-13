package com.example.applab5_jherrera_dguerrero_ggordon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.applab5_jherrera_dguerrero_ggordon.Dialog.Alerta;

public class MainActivity extends AppCompatActivity {
    EditText txtUser, txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InicializarControles();
    }

    private void InicializarControles() {
        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPass = (EditText) findViewById(R.id.txtPass);
    }

    public void Login(View vista){
        try{
            String nom, contra, password="jeymar12345", message;

            nom = txtUser.getText().toString();
            contra = txtPass.getText().toString();
            if(contra.equals(password) && nom.equals("Jeymar")){
                message ="Ingreso Satisfactorio";
                startActivity(new Intent(this, CredencialesActivity.class));

                Alerta alerta = new Alerta(message);
                alerta.show(getSupportFragmentManager(), "tag");
            }else{
                message="Datos Incorrectos";
                Alerta alerta = new Alerta(message);
                alerta.show(getSupportFragmentManager(), "tag");
            }
        }catch (Exception e){
            Toast.makeText(this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}