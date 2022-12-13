package com.example.jotaz.repasodetodo.InstagramView;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jotaz.repasodetodo.R;

import java.util.ArrayList;
import java.util.List;

public class InstagramViewAdapter extends ArrayAdapter<InstagramView>
{
    private List<InstagramView> listaOpciones = new ArrayList<>();

    public InstagramViewAdapter(Context context, List<InstagramView> datos){
        super(context, R.layout.listview_template, datos);

        listaOpciones= datos;
    }

    public View getView(int position, View v, ViewGroup vg)
    {
        LayoutInflater infalter = LayoutInflater.from(getContext());
        View item = infalter.inflate(R.layout.listview_template, null);

        ImageView imvUser = (ImageView)item.findViewById(R.id.imvUser);
        TextView lblUser = (TextView)item.findViewById(R.id.lblUser);
        TextView lblUltimo = (TextView)item.findViewById(R.id.lblUltimoMensaje);
        TextView lblHora = (TextView)item.findViewById(R.id.lblUltimaHora);

        imvUser.setImageResource(listaOpciones.get(position).getImgUser());
        lblUser.setText(listaOpciones.get(position).getUser());
        lblHora.setText(listaOpciones.get(position).getHora());
        lblUltimo.setText(listaOpciones.get(position).getMensaje());


        return (item);
    }
}
