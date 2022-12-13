package com.example.pedidosya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class NuevoRestauranteActivity extends AppCompatActivity {

    EditText nombre, lugar, precio, rating;
    TimePicker tiempo;
    CheckBox online;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_restaurante);

        InicializarControles();
    }

    private void InicializarControles(){
        nombre = (EditText) findViewById(R.id.txtNombre);
        lugar = (EditText) findViewById(R.id.txtLugar);
        precio = (EditText) findViewById(R.id.txtPrecio);
        rating= (EditText) findViewById(R.id.txtRating);

        tiempo = (TimePicker) findViewById(R.id.tpTiempo);

        online=(CheckBox) findViewById(R.id.chkPagoOnline);
    }


    public void GuardarDatos(View v){
        try {
            Bundle datos = new Bundle();
            datos.putString("nombre", nombre.getText().toString());
            datos.putString("lugar", lugar.getText().toString());
            datos.putDouble("precio", Double.parseDouble(precio.getText().toString()));
            datos.putDouble("rating", Double.parseDouble(rating.getText().toString()));

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                datos.putString("tiempo", tiempo.getHour()+":"+tiempo.getMinute());
            }

            int pago_online = 0;
            if(online.isChecked())pago_online=1;
            datos.putInt("online", pago_online);

            //de donde vengo hacia donde voy
            Intent i = new Intent(this, MainActivity.class);
            i.putExtras(datos);//pega los datos
            startActivity(i);//envia los datos




        }catch(Exception e){
            Toast.makeText(this, "Errorcito = ", Toast.LENGTH_SHORT).show();
        }

    }
}