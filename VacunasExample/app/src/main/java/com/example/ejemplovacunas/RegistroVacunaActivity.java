package com.example.ejemplovacunas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ejemplovacunas.Entidades.Estudiantes;
import com.example.ejemplovacunas.Entidades.Vacunas;

import java.util.List;

public class RegistroVacunaActivity extends AppCompatActivity {

    Spinner vacunas, dosis, estudiantes;
    CheckBox tieneChip;
    DatePicker fecha;
    ImageView fotoVacuna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_vacuna);
        InicializarControles();
        AttachEvents();
    }

    private void InicializarControles() {
        vacunas = (Spinner) findViewById(R.id.spnVacuna);
        dosis = (Spinner) findViewById(R.id.spnDosis);
        estudiantes = (Spinner) findViewById(R.id.spnEstudiante);
        tieneChip = (CheckBox) findViewById(R.id.chkChip);
        fecha = (DatePicker) findViewById(R.id.dpFecha);
        fotoVacuna = (ImageView) findViewById(R.id.imgVacuna);
        CargarSpinnerDosisVacunas();
        CargarSpinnerEstudiante();
    }

    private void AttachEvents() {
        vacunas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                switch(i){
                    case 0:
                        fotoVacuna.setImageResource(R.drawable.pfizer);
                        break;
                    case 1:
                        fotoVacuna.setImageResource(R.drawable.astrazeneca);
                        break;
                    case 2:
                        fotoVacuna.setImageResource(R.drawable.sputnik);
                        break;
                    case 3:
                        fotoVacuna.setImageResource(R.drawable.janssen);
                        break;
                    case 4:
                        fotoVacuna.setImageResource(R.drawable.sinovac);
                        break;
                    case 5:
                        fotoVacuna.setImageResource(R.drawable.moderna);
                        break;
                    case 6:
                        fotoVacuna.setImageResource(R.drawable.puente);
                        break;
                    default:
                        fotoVacuna.setImageResource(R.drawable.pfizer);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void CargarSpinnerEstudiante() {
        List<String> listEstudiantes = new Estudiantes().ObtenerNombreEstudiantes(this);
        ArrayAdapter adapterEstudiantes =
                new ArrayAdapter(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,listEstudiantes);
        estudiantes.setAdapter(adapterEstudiantes);
    }

    private void CargarSpinnerDosisVacunas() {
        ArrayAdapter adapterDosis = ArrayAdapter
                .createFromResource(this, R.array.dosis, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        ArrayAdapter adapterVacunas = ArrayAdapter
                .createFromResource(this, R.array.vacunas, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        vacunas.setAdapter(adapterVacunas);
        dosis.setAdapter(adapterDosis);
    }

    public void Vacunar(View v){
        try{
            String estudianteSeleccionado = estudiantes.getSelectedItem().toString();
            String fechaSeleccionada =  fecha.getDayOfMonth()+"-"+fecha.getMonth()+"-"+fecha.getYear();
            String dosisSeleccionada = dosis.getSelectedItem().toString();
            int chip = 0;
            if(tieneChip.isChecked()){
                chip = 1;
            }
            Vacunas vacuna = new Vacunas(
                  Integer.parseInt(dosisSeleccionada),
                  vacunas.getSelectedItem().toString(),
                  fechaSeleccionada,
            Integer.parseInt(estudianteSeleccionado.split("-")[0]),
            chip
            );

            boolean insertado = vacuna.insert(this);
            if (insertado){
                Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
            }else {
                Toast.makeText(this, "Error al Registrar", Toast.LENGTH_SHORT).show();
            }
        }catch(Exception e){
            Toast.makeText(this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}