package com.example.contorlsui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.contorlsui.Helpers.CustomDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre, txtApellido;
    TextView lblResultado;
    CheckBox chkMensaje;
    RadioGroup rbgLogos,rgbTiposJuegos;
    ImageView imvLogo;
    Button btnConcat;
    Spinner spnJuegos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InicializarControler();
        this.Validatebutton();
    }

    private void InicializarControler(){
        txtNombre = (EditText)findViewById(R.id.txtNombre);
        txtApellido = (EditText)findViewById(R.id.txtApellido);

        lblResultado = (TextView)findViewById(R.id.lblRes);

        chkMensaje = (CheckBox)findViewById(R.id.chkDialog);

        rbgLogos = (RadioGroup)findViewById(R.id.rbgLogos);
        rgbTiposJuegos = (RadioGroup)findViewById(R.id.rgbTipoJuegos);

        imvLogo = (ImageView)findViewById(R.id.imvLogo);

        btnConcat = (Button)findViewById(R.id.btnConcatenar);

        spnJuegos = (Spinner)findViewById(R.id.spnJuegos);
    }

    public void Concatenar(View v){
        try {
            String nombre = txtNombre.getText().toString();
            String apellido = txtApellido.getText().toString();
            String juego = this.ObtenerJuegoSeleccionado();
            if (chkMensaje.isChecked()){
                FragmentManager fm = getSupportFragmentManager();
                CustomDialog dialog = new CustomDialog("Hola: "+nombre,"Tu juego favorito es: " + juego);
                dialog.show(fm,"DIALOG");
            }

            this.PonerLogo();
            lblResultado.setText(nombre + " " + apellido + " \n Juego Favorito: " + juego);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage().toString(),Toast.LENGTH_LONG).show();
        }
    }

    private void PonerLogo(){
        switch (rbgLogos.getCheckedRadioButtonId()){
            case R.id.rbtLogoFisc :
                imvLogo.setImageResource(R.drawable.fisc);
                break;
            case R.id.rbtLogoUTP :
                imvLogo.setImageResource(R.drawable.utp);
                break;
            default:
                imvLogo.setImageResource(R.drawable.ic_launcher_background);
                break;
        }
    }

    private void Validatebutton(){
        btnConcat.setEnabled(false);
        if (txtNombre.getText().length() > 0 && txtApellido.getText().length() > 0){
            btnConcat.setEnabled(true);
        }
    }

    public void ValidarButton (View v){
        this.Validatebutton();
    }

    private List<String> ObtenerJuegos(){
        List<String> juegos = new ArrayList<String>();
        //AQUI VA LA LOGICA PARA OBTENER DATOS DESDE BD LOCAL O WEBSERVICE
        juegos.add("Godofwar");
        juegos.add("Fornai");
        juegos.add("Smashito");
        juegos.add("The Witcher");
        juegos.add("Resident Evil");

        return juegos;
    }

    private void InicializarSpinner(){
        ArrayAdapter<CharSequence> adapterPS5 = ArrayAdapter
                .createFromResource(getApplicationContext(),R.array.juegosPS5,R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterXBOX = ArrayAdapter
                .createFromResource(getApplicationContext(),R.array.juegosXbox,R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterSwitch =
                new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,this.ObtenerJuegos());

        switch (rgbTiposJuegos.getCheckedRadioButtonId()){
            case R.id.rbtSwitch:
                spnJuegos.setAdapter(adapterSwitch);
                break;
            case R.id.rbtPS5:
                spnJuegos.setAdapter(adapterPS5);
                break;
            case R.id.rbtXbox:
                spnJuegos.setAdapter(adapterXBOX);
                break;
        }
    }

    private String ObtenerJuegoSeleccionado(){
        try {
            return (String)spnJuegos.getSelectedItem();
        }catch (Exception e){

        }
        return "";
    }

    public void CargarSpinner(View view){
        this.InicializarSpinner();
    }
}