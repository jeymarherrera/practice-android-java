package com.example.jotaz.repasodetodo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.jotaz.repasodetodo.InstagramView.InstagramView;
import com.example.jotaz.repasodetodo.InstagramView.InstagramViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    ListView lstOpciones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lstOpciones = (ListView)findViewById(R.id.lstOpciones);

        InstagramViewAdapter adapter = new InstagramViewAdapter(this, LoadActivity());

        lstOpciones.setAdapter(adapter);
    }


    private List<InstagramView> LoadActivity()
    {
        List<InstagramView> opciones = new ArrayList<>();

        opciones.add(new InstagramView("JRosas","Me estoy quedando","12 H", R.drawable.fisc));
        opciones.add(new InstagramView("HakimS","Profe, manana hay clases?","5 H", R.drawable.telef));
        opciones.add(new InstagramView("LuisM","Una pregunta profe.","1 H", R.drawable.logoa));
        opciones.add(new InstagramView("EfrainP","Javascript profe","5 H", R.drawable.logob));
        opciones.add(new InstagramView("BrianN","Me quede dormido","23 H",R.drawable.logo));
        opciones.add(new InstagramView("MarioM","Profe, estoy en la lista","1 H", R.drawable.tel));
        opciones.add(new InstagramView("VictorT","Profe, a que hora es el lab","10 H", R.drawable.tele));

        return opciones;
    }
}
