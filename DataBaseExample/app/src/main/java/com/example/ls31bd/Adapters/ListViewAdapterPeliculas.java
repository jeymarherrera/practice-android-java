package com.example.ls31bd.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ls31bd.R;
import com.example.ls31bd.Entidades.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapterPeliculas extends ArrayAdapter<Pelicula> {

    private List<Pelicula> peliculas = new ArrayList<>();

    public ListViewAdapterPeliculas(Context context, List<Pelicula> datos){
        super(context, R.layout.listview_peliculas, datos);
        peliculas = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_peliculas, null);

        TextView rating = (TextView)item.findViewById(R.id.lblRating);
        rating.setText(Float.toString(peliculas.get(position).getPuntuacion()));

        TextView titulo = (TextView)item.findViewById(R.id.lblTitulo);
        titulo.setText(peliculas.get(position).getTitulo());

        TextView descripcion = (TextView)item.findViewById(R.id.lblDescripcion);
        descripcion.setText(peliculas.get(position).getDescripcion());

        TextView horas = (TextView)item.findViewById(R.id.lblHoras);
        horas.setText(Integer.toString(peliculas.get(position).getDuracion()));

        TextView categoria = (TextView)item.findViewById(R.id.lblCategoria);
        horas.setText(peliculas.get(position).getCtaegoria());

        return(item);
    }
}
