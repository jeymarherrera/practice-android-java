package com.example.parcial2v5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import com.example.parcial2v5.MainActivity;
import com.example.parcial2v5.Adaptersview.ListviewMateriasadapter;
import com.example.parcial2v5.Adaptersview.UsuarioView;
public class PantallaMaterias extends AppCompatActivity {

    private UsuarioView user;
    ListView lstOpciones;
    TextView nombreusuario;
    Button guardar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_pantalla_materias);
        guardar   = (Button) findViewById(R.id.ButGuardar);
        lstOpciones =(ListView)  findViewById(R.id.lstOpciones);
        nombreusuario =(TextView ) findViewById(R.id.txtuser);
        ListviewMateriasadapter adapter = new ListviewMateriasadapter(this,LoadActivity());
        lstOpciones.setAdapter(adapter);

}






    private List< UsuarioView> LoadActivity()
    {

        SharedPreferences preferencias = getSharedPreferences("usuario",MODE_PRIVATE);


        String user = preferencias.getString("user","");

       String n1,n2,n3,n4,n5,n6,n7,n8,n9,n10;
        String t="1";
              t = preferencias.getString("tipo","1");

          int tipo= Integer.parseInt(t);
                  n1=preferencias.getString("nota1","");
                  n2=preferencias.getString("nota2","");
                  n3=preferencias.getString("nota3","");
                  n4=preferencias.getString("nota4","");
                  n5=preferencias.getString("nota5","");
                  n6=preferencias.getString("nota6","");
                  n7=preferencias.getString("nota7","");
                  n8=preferencias.getString("nota8","");
                  n9=preferencias.getString("nota9","");
                  n10=preferencias.getString("nota10","");

       if(tipo==1){



       }else{
           guardar.setVisibility(View.VISIBLE);
            }

        List< UsuarioView> opciones = new ArrayList<>();
        MainActivity obj= new MainActivity();
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(openFileInput("login.txt")));
            String recorrido = null;


            while((recorrido = bf.readLine()) !=null) {
                String[] credenciales = recorrido.split("~");

                if ((user).equals(credenciales[0])) {
                    nombreusuario.setText(credenciales[2]);
                    opciones.add(new  UsuarioView("Matematicas","Semestre I",n1, R.drawable.matetica,tipo));   // imagenes 72X72
                    opciones.add(new  UsuarioView("Geografia","Semestre I",n2,R.drawable.geografia,tipo));
                    opciones.add(new  UsuarioView("Ciencias","Semestre I",n3,R.drawable.ciencia,tipo));
                    opciones.add(new  UsuarioView("Calculo","Semestre I",n4, R.drawable.fisica1232,tipo));
                    opciones.add(new  UsuarioView("Tecnologia","Semestre I",n5, R.drawable.fisica1232,tipo)); ////nuevo
                    opciones.add(new  UsuarioView("Ingles","Semestre I",n6, R.drawable.matetica,tipo));   // imagenes 72X72
                    opciones.add(new  UsuarioView("Religion","Semestre I",n7,R.drawable.geografia,tipo));
                    opciones.add(new  UsuarioView("Fisica","Semestre I",n8,R.drawable.ciencia,tipo));
                    opciones.add(new  UsuarioView("Filosofia","Semestre I",n9, R.drawable.fisica1232,tipo));
                    opciones.add(new  UsuarioView("Matematicas 2","Semestre I",n10, R.drawable.fisica1232,tipo));
                }

            }



            bf.close();
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Error! "+e.getMessage(),Toast.LENGTH_LONG).show();
        }


        return opciones;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SharedPreferences preferencias = getSharedPreferences("usuario",MODE_PRIVATE);
        String t="1";
        t = preferencias.getString("tipo","1");

        int tipo= Integer.parseInt(t);
        if(tipo==0){

            getMenuInflater().inflate(R.menu.menu, menu);
            guardar.setVisibility(View.INVISIBLE);
            return true;


        }else{
            guardar.setVisibility(View.INVISIBLE);
            return false;
        }




    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.miNew:


                Toast.makeText(this,"Selecciono el menu", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, Guardar.class));
                break;
            default:
                return true;
        };

        return true;
    }



    public void guardar(View view ){

        startActivity(new Intent(getApplicationContext(),Guardar.class));


    }

}