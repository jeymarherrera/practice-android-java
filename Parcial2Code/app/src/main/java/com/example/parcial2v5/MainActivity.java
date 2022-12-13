package com.example.parcial2v5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.parcial2v5.Adaptersview.ListviewMateriasadapter;
import com.example.parcial2v5.Adaptersview.UsuarioView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText cedula, contrasena;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InicializarControles();
        this.CargaInicial();

    }



    private void InicializarControles() {
        cedula = (EditText) findViewById(R.id.txtCedulaL);
        contrasena = (EditText) findViewById(R.id.txtContrasenaL);
    }

    private void CargaInicial() {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(openFileOutput("login.txt", Context.MODE_PRIVATE));
            //                    cedula            contraseña         nombre                         notas
            writer.write("20-70-6045" + "~" + "admin123"+"~"+"Jeymar Herrera"      +"~"+"A"+"~"+"F"+"~"+"C"+"~"+"D"+"~"+"D"+"~"+"A"+"~"+"F"+"~"+"C"+"~"+"D"+"~"+"D"+"\n");
            writer.write("08-70-4560" + "~" + "admin12345"+"~"+"Jesus opez"        +"~"+"A"+"~"+"F"+"~"+"C"+"~"+"D"+"~"+"D"+"~"+"A"+"~"+"F"+"~"+"C"+"~"+"D"+"~"+"D"+"\n");
            writer.write("09-70-6045" + "~" + "admin123"+"~"+"Homar Torrijos"      +"~"+"A"+"~"+"F"+"~"+"C"+"~"+"D"+"~"+"D"+"~"+"A"+"~"+"F"+"~"+"C"+"~"+"D"+"~"+"D"+"\n");
            writer.write("07-70-4560" + "~" + "admin12345"+"~"+"Gevara Daniel"     +"~"+"A"+"~"+"F"+"~"+"C"+"~"+"D"+"~"+"D"+"~"+"A"+"~"+"F"+"~"+"C"+"~"+"D"+"~"+"D"+"\n");
            writer.write("06-70-6045" + "~" + "admin123"+"~"+"Hernesto Cordoba"    +"~"+"A"+"~"+"F"+"~"+"C"+"~"+"D"+"~"+"D"+"~"+"A"+"~"+"F"+"~"+"C"+"~"+"D"+"~"+"D"+"\n");




            writer.close();
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error!"+e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void ValidarUsuario(View v) {

        SharedPreferences preferencias = getSharedPreferences("usuario",MODE_PRIVATE);



        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(openFileInput("login.txt")));
            String recorrido = null;
            boolean existeUsuario = false;

            while((recorrido = bf.readLine()) !=null){
                String[] credenciales = recorrido.split("~");

                if (cedula.getText().toString().equals(credenciales[0]) && contrasena.getText().toString().equals(credenciales[1])) {
                    Toast.makeText(getApplicationContext(),"Bienvenido al Nuevo Sistema de Matricula",Toast.LENGTH_LONG).show();
                     SharedPreferences.Editor editor = preferencias.edit();
                          editor.putString("user",credenciales[0]);
                          editor.putString("nota1",credenciales[3]);
                          editor.putString("nota2",credenciales[4]);
                          editor.putString("nota3",credenciales[5]);
                          editor.putString("nota4",credenciales[6]);
                          editor.putString("nota5",credenciales[7]);
                          editor.putString("nota6",credenciales[8]);
                          editor.putString("nota7",credenciales[9]);
                          editor.putString("nota8",credenciales[10]);
                          editor.putString("nota9",credenciales[11]);
                          editor.putString("nota10",credenciales[12]);
                   editor.commit();



                         startActivity(new Intent(getApplicationContext(),ProfileActivity.class));


                }
            }
            if(!existeUsuario) {
                Toast.makeText(getApplicationContext(),"Cedula o Contraseña Incorrecta",Toast.LENGTH_LONG).show();
            }
            bf.close();
        }







        catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Error! "+e.getMessage(),Toast.LENGTH_LONG).show();
        }




    }

    private void Prueba() {
    }


}




