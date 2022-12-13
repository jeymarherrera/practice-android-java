package com.example.lab_sff_3.apptaller1_jherrera_ggordon_dguerrero;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lab_sff_3.apptaller1_jherrera_ggordon_dguerrero.Dialog.Alerta;

public class MainActivity extends Activity {


    EditText user;
    EditText pass;
    RadioButton  radio_prof;
    RadioButton radio_est;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    inicializar();

    }

    public void inicializar(){
        user = (EditText)findViewById(R.id.user);
        pass = (EditText)findViewById(R.id.pass);
        radio_prof = (RadioButton)findViewById(R.id.radio_prof);
        radio_est = (RadioButton)findViewById(R.id.radio_est);

    }




    public void  Loguear(View vista){

        if (radio_est.isChecked()){


        String UserEstudiante="20-70-5046";
        String PssEstudiante="1234.,1234";

        if(user.equals(UserEstudiante) && pass.equals(PssEstudiante) ){


        }

        else {

            Alerta alerta = new Alerta("Estudiante");
            alerta.show(getFragmentManager(), "tag");

        }



    }

        else if (radio_prof.isChecked()){

        String userPro="8-442-4412";
        String PssPro="1234.,1234";

        if(user.equals(userPro) && pass.equals(PssPro) ){



        }

        else{

            Alerta alerta = new Alerta("Profesor");
            alerta.show(getFragmentManager(), "tag");


        }



        }




    }



































    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
