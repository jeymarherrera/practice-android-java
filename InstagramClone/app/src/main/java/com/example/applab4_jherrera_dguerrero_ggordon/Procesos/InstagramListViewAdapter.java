package com.example.applab4_jherrera_dguerrero_ggordon.Procesos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.applab4_jherrera_dguerrero_ggordon.InstagramActivity;
import com.example.applab4_jherrera_dguerrero_ggordon.R;

import java.util.ArrayList;
import java.util.List;

public class InstagramListViewAdapter extends ArrayAdapter {

    private List<Chat> opciones = new ArrayList<>();

    public InstagramListViewAdapter(Context context, List<Chat> datos){
        super(context, R.layout.listview_layout_template, datos);

        opciones = datos;
    }


    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_layout_template, null);

        ImageView foto =(ImageView)item.findViewById(R.id.imagenPerfil);
        foto.setImageResource(opciones.get(position).getFoto());

        TextView lblTitulo = (TextView) item.findViewById(R.id.lblTitulo);
        lblTitulo.setText(opciones.get(position).getUsuario());

        TextView lblSubtitulo = (TextView) item.findViewById(R.id.lblSubtitulo);
        lblSubtitulo.setText(opciones.get(position).getMensaje());

        TextView lblNota = (TextView) item.findViewById(R.id.lblNota);
        lblNota.setText(opciones.get(position).getHora());

        return (item);
    }
}
