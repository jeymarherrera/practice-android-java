package com.example.loginspa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText user,pass;
    RadioGroup tipoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InicializarControles();
        this.CargarInicial();
    }

    private void CargarInicial() {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(openFileOutput("login.txt",Context.MODE_PRIVATE));
            writer.write("admin"+"~"+"admin123");
            writer.close();

        }catch (Exception e){

        }
    }

    private void InicializarControles(){
        user = (EditText)findViewById(R.id.txtUser);
        pass = (EditText)findViewById(R.id.txtPass);

        tipoLogin = (RadioGroup)findViewById(R.id.rbgLogin);
    }

    public void ValidarUsuario(View v){
        try {
              BufferedReader bf = new BufferedReader(new InputStreamReader(openFileInput("login.txt")));
                String[] credenciales = bf.readLine().split("~");
                bf.close();

                if (user.getText().toString().equals(credenciales[0]) && pass.getText().toString().equals(credenciales[1])){
                    Toast.makeText(getApplicationContext(),"SI LOGUEA",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(),RegistroActivity.class));
            }
                else{
                    Toast.makeText(getApplicationContext(),"NOOO LOGUEA",Toast.LENGTH_LONG).show();
                }

        }catch (Exception e){

        }
    }


}