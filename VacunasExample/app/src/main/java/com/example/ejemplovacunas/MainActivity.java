package com.example.ejemplovacunas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ejemplovacunas.Adaptadores.VacunadosListViewAdapter;
import com.example.ejemplovacunas.Entidades.Estudiantes;
import com.example.ejemplovacunas.Entidades.Vacunas;
import com.example.ejemplovacunas.Helpers.Vacunados;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lstEstudiantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InicializarControles();
        AttachEvents();
    }

    private void InicializarControles(){
        lstEstudiantes = (ListView) findViewById(R.id.lstEstudiantes);
        CargarListView();
    }

    private void AttachEvents(){
        lstEstudiantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "pos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void CargarListView() {
        /*List<String> nombreEstudiantes = new Estudiantes().ObtenerNombreEstudiantes(getApplicationContext());
        ArrayAdapter adapter = new ArrayAdapter<>(getApplication(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, nombreEstudiantes);
        lstEstudiantes.setAdapter(adapter);*/

        List<Vacunados> vacunados = new Vacunados().ObtenerListadoVacunados(getApplicationContext());
        VacunadosListViewAdapter adapter = new VacunadosListViewAdapter(getApplication(), R.layout.listview_vacunados, vacunados);
        lstEstudiantes.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mitemEstudiante:
                startActivity(new Intent(this, RegistroEstudiante.class));
                break;
            case R.id.mitemDosis:
                startActivity(new Intent(this, RegistroVacunaActivity.class));
                break;
            default:
                break;
        }
        return true;
    }
}