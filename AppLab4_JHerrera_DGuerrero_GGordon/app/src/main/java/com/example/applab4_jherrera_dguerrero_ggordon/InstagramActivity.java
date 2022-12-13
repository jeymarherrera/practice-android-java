package com.example.applab4_jherrera_dguerrero_ggordon;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.applab4_jherrera_dguerrero_ggordon.Procesos.InstagramListViewAdapter;
import com.example.applab4_jherrera_dguerrero_ggordon.Procesos.Chat;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class InstagramActivity extends AppCompatActivity {

    ListView lstOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);

        this.InitializeControls();
        this.LoadListViewTemplate();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        Toast.makeText(this, "Has presionado el menu", Toast.LENGTH_SHORT).show();
        return true;
    }

    private void InitializeControls() {
        lstOpciones = (ListView) findViewById(R.id.lstOpciones);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                String opcionSeleccionada = ((Chat) a.getItemAtPosition(position)).getUsuario();

                Toast.makeText(InstagramActivity.this, "Mensaje Seleccionado" + opcionSeleccionada, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void LoadListViewTemplate() {
        List<Chat> opciones = this.GetElementToListViewTemplate();

        InstagramListViewAdapter adapter = new InstagramListViewAdapter(this, opciones);

        lstOpciones.setAdapter(adapter);
    }

    private List<Chat> GetElementToListViewTemplate() {
        List<Chat> opciones = new ArrayList<> ();
        opciones.add(new Chat(R.drawable.user001, "Pedro Perez", "Hola, soy Pedro! Como estas?", "5:26"));
        return opciones;
    }

}