package com.example.parcial2v5.Adaptersview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parcial2v5.PantallaMaterias;
import com.example.parcial2v5.R;

import java.util.ArrayList;
import java.util.List;

public class ListviewMateriasadapter extends ArrayAdapter<UsuarioView> {


        private List<UsuarioView> listaOpciones = new ArrayList<>();

    public ListviewMateriasadapter(Context context, List<UsuarioView> datos){
        super(context, R.layout.activity_pantalla_materias, datos);

        listaOpciones= datos;
    }

        public View getView(int position, View v, ViewGroup vg)
        {
            LayoutInflater infalter = LayoutInflater.from(getContext());
            View item = infalter.inflate(R.layout.listview_template, null);





            TextView Estatico = (TextView) item.findViewById(R.id.Estatico);

            ImageView imvUser = (ImageView)item.findViewById(R.id.imvUser);
            TextView lblUser = (TextView)item.findViewById(R.id.lblUser);
            TextView lblUltimo = (TextView)item.findViewById(R.id.lblUltimoMensaje);
            TextView lblHora = (TextView)item.findViewById(R.id.lblUltimaHora);

            imvUser.setImageResource(listaOpciones.get(position).getImgUser());
            lblUser.setText(listaOpciones.get(position).getUser());
            lblUltimo.setText(listaOpciones.get(position).getMensaje());
            ImageView corazon = (ImageView)item.findViewById(R.id.imvCamara);


            if(listaOpciones.get(position).getHora().equals("A") || listaOpciones.get(position).getHora().equals("B") ||listaOpciones.get(position).getHora().equals("C")  || listaOpciones.get(position).getHora().equals("D") ||listaOpciones.get(position).getHora().equals("F") ){

                lblHora.setText(listaOpciones.get(position).getHora());
                Estatico.setText(listaOpciones.get(position).getHora());
            }else
            {
                lblHora.setText("SN");
                Estatico.setText("SN");

            }


            if (listaOpciones.get(position).getHora().equals("F")){  ///2
                corazon.setImageResource(R.drawable.x);
            }else if(listaOpciones.get(position).getHora().equals("D")){
                corazon.setImageResource(R.drawable.x);
            }else{
                corazon.setImageResource(R.drawable.circulo);


            }



            return item;
        }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position,convertView,parent);
    }
}