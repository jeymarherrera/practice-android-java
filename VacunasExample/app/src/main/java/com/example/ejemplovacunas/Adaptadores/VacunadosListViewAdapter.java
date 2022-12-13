package com.example.ejemplovacunas.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.ejemplovacunas.Entidades.Vacunas;
import com.example.ejemplovacunas.Helpers.Vacunados;
import com.example.ejemplovacunas.R;

import java.util.ArrayList;
import java.util.List;

public class VacunadosListViewAdapter extends ArrayAdapter {
    List<Vacunados> opciones = new ArrayList<>();

    public VacunadosListViewAdapter(@NonNull Context context, int resource, List<Vacunados>datos) {
        super(context, resource, datos);
    }

    public View getView(int position, View v, ViewGroup viewGrou) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_vacunados, null);

        TextView nombre = (TextView) item.findViewById(R.id.lblNombre);
        nombre.setText(opciones.get(position).getNombre());

        TextView cedula = (TextView) item.findViewById(R.id.lblCedula);
        cedula.setText(opciones.get(position).getCedula());

        TextView edad = (TextView) item.findViewById(R.id.lblEdad);
        nombre.setText("/" + opciones.get(position).getEdad());

        TextView correo = (TextView) item.findViewById(R.id.lblCorreo);
        correo.setText(opciones.get(position).getCorreo());

        TextView telefono = (TextView) item.findViewById(R.id.lblTelefono);
        telefono.setText(opciones.get(position).getTelefono());

        ImageView chip =  (ImageView) item.findViewById(R.id.imvChip);
        if (opciones.get(position).getChip() == 0) {
            chip.setVisibility(View.INVISIBLE);
        }

        ImageView dosis1 = (ImageView) item.findViewById(R.id.imvDosis1);
        if (opciones.get(position).getDosis() >= 1) {
            dosis1.setImageResource(R.drawable.vaccine);
        }


        ImageView dosis2 = (ImageView) item.findViewById(R.id.imvDosis2);
        if (opciones.get(position).getDosis() >= 1) {
            dosis2.setImageResource(R.drawable.vaccine);
        }

        ImageView dosis3 = (ImageView) item.findViewById(R.id.imvDosis3);
        if (opciones.get(position).getDosis() >= 1) {
            dosis3.setImageResource(R.drawable.vaccine);
        }
        return item;
    }

}
