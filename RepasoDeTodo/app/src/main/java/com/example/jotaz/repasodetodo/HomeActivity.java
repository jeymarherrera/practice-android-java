package com.example.jotaz.repasodetodo;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    EditText user, pass;
    RadioGroup tipo;

    RadioButton est, prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.InicializarControles();
    }


    private void InicializarControles()
    {
        user = (EditText)findViewById(R.id.txtUsuario);
        pass = (EditText)findViewById(R.id.txtContrasena);

        tipo = (RadioGroup)findViewById(R.id.rbgTipo);

        est = (RadioButton)findViewById(R.id.rbtEstudiante);
        prof = (RadioButton)findViewById(R.id.rbtProfesor);
    }

    public void Login(View view)
    {
        try{

            if(est.isChecked())
            {
                if (user.getText().toString().equals("juanz33"))
                {
                    if (pass.getText().toString().equals("123"))
                    {
                        Intent i = new Intent(this, OtraActivity.class);
                        i.putExtra("Usuario", user.getText().toString());
                        i.putExtra("Contrasena", pass.getText().toString());
                        startActivity(i);
                    }
                }
                else
                {
                    Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_LONG).show();
                }
            }
            else if (prof.isChecked())
            {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ecampus.utp.ac.pa/moodle"));
                startActivity(i);
            }
            else
            {
                Toast.makeText(this, "Selecciona una opcion por favor", Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Error aqui " + e.getMessage().toString(), Toast.LENGTH_LONG).show();
        }
    }

    public void AbrirListView(View view)
    {
        Intent i = new Intent(this, ListViewActivity.class);
        startActivity(i);
    }


}
