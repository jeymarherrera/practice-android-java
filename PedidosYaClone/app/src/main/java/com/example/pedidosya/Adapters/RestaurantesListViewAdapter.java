package com.example.pedidosya.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.pedidosya.Entidades.Restaurantes;
import com.example.pedidosya.R;

import java.util.ArrayList;
import java.util.List;

public class RestaurantesListViewAdapter extends ArrayAdapter {

    private List<Restaurantes> opciones = new ArrayList<>();

    public RestaurantesListViewAdapter(Context context, List<Restaurantes> datos) {
        super(context, R.layout.listview_restaurantes, datos);

        this.opciones = datos;
    }

    public View getView(int position, View v, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_restaurantes, null);

        TextView nombre = (TextView) item.findViewById(R.id.txtNombre);
        nombre.setText(opciones.get(position).getNombre());

        TextView direccion = (TextView) item.findViewById(R.id.txtDireccion);
        direccion.setText(opciones.get(position).getDireccion());

        TextView rating = (TextView) item.findViewById(R.id.txtRating);
        rating.setText(Double.toString(opciones.get(position).getRating()));

        TextView tiempo = (TextView) item.findViewById(R.id.txtTiempo);
        tiempo.setText(opciones.get(position).getTiempo());

        TextView costo = (TextView) item.findViewById(R.id.txtCosto);
        costo.setText(opciones.get(position).getCosto());

        ImageView logo = (ImageView) item.findViewById(R.id.ico);
        logo.setImageResource(opciones.get(position).getLogo());

        TextView online = (TextView) item.findViewById(R.id.pago_online);
        if (opciones.get(position).getOnline() == 0) {
            online.setVisibility(View.INVISIBLE);
        }

        ImageView corazon = (ImageView) item.findViewById(R.id.imgHeart);
        int favorito = opciones.get(position).getFavorito();

        if (favorito == 1) {
            corazon.setImageResource(R.drawable.corazon);
        } else {
            corazon.setImageResource(R.drawable.heart);
        }
        return item;
    }
}
