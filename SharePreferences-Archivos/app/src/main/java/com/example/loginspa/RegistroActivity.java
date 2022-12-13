package com.example.loginspa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;

public class RegistroActivity extends AppCompatActivity {

    EditText user,pass;
    RadioGroup tipoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        this.InicializarControles();
    }

    private void InicializarControles(){
        user = (EditText)findViewById(R.id.txtUserR);
        pass = (EditText)findViewById(R.id.txtPassR);

        tipoLogin = (RadioGroup)findViewById(R.id.rbgLoginR);
    }


    public void InsertarUsuario(View v){
        try {
            String u = user.getText().toString();
            String p = pass.getText().toString();
            switch (tipoLogin.getCheckedRadioButtonId()){
                case R.id.rbtAR:
                    GuardarArchivo(u,p);
                    break;
                case  R.id.rbtSPR:
                    GuardarPorSharedPreferences(u,p);
                    break;
                default:
                    Toast.makeText(getApplicationContext(),"No ha seleccionado una opcion",Toast.LENGTH_LONG).show();
                    break;
            }
        }catch (Exception e){

        }
    }

    private void GuardarPorSharedPreferences(String u, String p) {
        try{
            SharedPreferences prefs = getSharedPreferences("Login", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("user",u);
            editor.putString("pass",p);
            editor.commit();
        }
        catch (Exception e){

        }
    }

    private void GuardarArchivo(String u, String p) {
        OutputStreamWriter writer = null;
        try {
            writer = new OutputStreamWriter(openFileOutput("login.txt", Context.MODE_PRIVATE));
            writer.write(u+"~"+p);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}