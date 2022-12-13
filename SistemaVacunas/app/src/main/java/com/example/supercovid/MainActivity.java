package com.example.supercovid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.supercovid.Adaptadores.VacunadosListviewAdapter;
import com.example.supercovid.Entidades.Estudiantes;
import com.example.supercovid.Entidades.Vacunados;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lstEstudiantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InicializarControles();
        AttachEvents();
    }

    private void InicializarControles() {
        lstEstudiantes = (ListView)findViewById(R.id.lstEstudiantes);
        CargarListview();
    }

    private void AttachEvents(){
        lstEstudiantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"pos"+i,Toast.LENGTH_LONG).show();
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.madres);
                mp.start();
            }
        });
    }

    private void CargarListview() {
        /*List<String> nombreEstudiantes = new Estudiantes().ObtenerNombreEstudiantes(getApplicationContext());
        ArrayAdapter adapter = new ArrayAdapter<>(getApplication(),R.layout.support_simple_spinner_dropdown_item,nombreEstudiantes);
        lstEstudiantes.setAdapter(adapter);*/

        List<Vacunados> vacunados = new Vacunados().ObtenerListadoVacunados(getApplicationContext());
        VacunadosListviewAdapter adapter = new VacunadosListviewAdapter(getApplicationContext(),vacunados);
        lstEstudiantes.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mitemEstudiante:
                startActivity(new Intent(this,RegistroEstudianteActivity.class));
                break;
            case R.id.mitemDosis:
                startActivity(new Intent(this,RegistroVacunasActivity.class));
                break;
            default:
                break;
        }

        return true;
    }
}