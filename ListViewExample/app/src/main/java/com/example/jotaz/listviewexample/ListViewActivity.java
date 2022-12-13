package com.example.jotaz.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jotaz.listviewexample.ListViewTemplate.ListViewAdapterPropio;
import com.example.jotaz.listviewexample.ListViewTemplate.Titulos;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    ListView lstOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        this.InitializeControls();
        //this.LoadListView();
        this.LoadListViewTemplate();
    }

    private void InitializeControls()
    {
        lstOpciones = (ListView)findViewById(R.id.lstOpciones);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                String opcionSeleccionada =
                        ((Titulos)a.getItemAtPosition(position)).getTitulo();

                //Alternativa 2:
                //String opcionSeleccionada =
                //      ((TextView)v.findViewById(R.id.LblTitulo))
                //          .getText().toString();

                Toast.makeText(ListViewActivity.this,"Opción seleccionada: " + opcionSeleccionada, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void LoadListView()
    {
        List<String> opciones = this.GetElementsToListView();

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opciones);

        lstOpciones.setAdapter(adaptador);

    }

    private void LoadListViewTemplate()
    {
        List<Titulos> opciones = this.GetElementsToListViewTemplate();

        ListViewAdapterPropio adapter = new ListViewAdapterPropio(this, opciones);

        lstOpciones.setAdapter(adapter);
    }

    private List<String> GetElementsToListView()
    {
        List<String> opciones = new ArrayList<String>();

        opciones.add("Parciales");
        opciones.add("Laboratorios");
        opciones.add("Quices");
        opciones.add("Practicas");
        opciones.add("Asistencia");
        opciones.add("Portafolio");

        return  opciones;

    }

    private List<Titulos> GetElementsToListViewTemplate()
    {
        List<Titulos> opciones = new ArrayList<Titulos>();

        opciones.add(new Titulos("Parciales", "Dificles", "A"));
        opciones.add(new Titulos("Laboratorios", "Haganlos todos","D"));
        opciones.add(new Titulos("Quices", "Usamos Kahoot","F"));
        opciones.add(new Titulos("Asistencia", "no falten","B"));
        opciones.add(new Titulos("Portafolio", "Lastimosamente hay que hacerlo","F"));

        return  opciones;

    }
}
