package com.example.supercovid;

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

import com.example.supercovid.Entidades.Estudiantes;
import com.example.supercovid.Entidades.Vacunas;

import java.util.List;

public class RegistroVacunasActivity extends AppCompatActivity {

    Spinner vacunas,dosis,estudiantes;
    CheckBox tieneChip;
    DatePicker fecha;
    ImageView fotoVacuna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_vacunas);

        InicializarControler();
        AttachEvents();
    }

    private void AttachEvents() {
        vacunas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        fotoVacuna.setImageResource(R.drawable.pfzier);
                        break;
                    case 1:
                        fotoVacuna.setImageResource(R.drawable.astrazeneca);
                        break;
                    case 2:
                        fotoVacuna.setImageResource(R.drawable.sputnik);
                        break;
                    case  3:
                        fotoVacuna.setImageResource(R.drawable.jhonson);
                        break;
                    case 4:
                        fotoVacuna.setImageResource(R.drawable.sinovac);
                        break;
                    case 5:
                        fotoVacuna.setImageResource(R.drawable.moderna);
                        break;
                    case 6:
                        fotoVacuna.setImageResource(R.drawable.sanmiguelito);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void InicializarControler() {
        vacunas = (Spinner)findViewById(R.id.spnVacunas);
        dosis = (Spinner)findViewById(R.id.spnDosis);
        estudiantes = (Spinner)findViewById(R.id.spnEstudiantes);

        CargarSpinnerDosisVacunas();
        CargarSpinnerEstudiantes();

        tieneChip = (CheckBox)findViewById(R.id.chkChip);
        fecha = (DatePicker)findViewById(R.id.dtFecha);

        fotoVacuna = (ImageView)findViewById(R.id.imvVacuna);
    }

    private void CargarSpinnerEstudiantes() {
        List<String> listEstudiantes = new Estudiantes().ObtenerNombreEstudiantes(this);
        ArrayAdapter adapterEstudiantes =
                new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,listEstudiantes);
        estudiantes.setAdapter(adapterEstudiantes);
    }

    private void CargarSpinnerDosisVacunas() {
        ArrayAdapter adapterDosis = ArrayAdapter
                .createFromResource(this,R.array.dosis,R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter adapterVacunas = ArrayAdapter
                .createFromResource(this,R.array.vacunas,R.layout.support_simple_spinner_dropdown_item);

        vacunas.setAdapter(adapterVacunas);
        dosis.setAdapter(adapterDosis);
    }

    public void Vacunar(View v){
        try {
            String estudianteSeleccionado = estudiantes.getSelectedItem().toString();
            String fechaSeleccionada = fecha.getDayOfMonth()+"-"+fecha.getMonth()+"-"+fecha.getYear();
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
                Toast.makeText(this,"Woooeee, se inserto",Toast.LENGTH_LONG).show();
                startActivity(new Intent(this,MainActivity.class));
            }else{
                Toast.makeText(this,"Ya valio y no inserto :(",Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Toast.makeText(this,"Errorcito =>"+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}