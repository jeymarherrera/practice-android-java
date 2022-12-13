package com.example.applab3_jherrera_dguerrero_ggordon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applab3_jherrera_dguerrero_ggordon.Dialog.Alerta;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtNum1, txtNum2;
    TextView lblResultado;
    CheckBox chkDialog;
    Spinner spnOperacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InicializarControles();
    }

    private void InicializarControles() {
        txtNum1 = (EditText) findViewById(R.id.txtNum1);
        txtNum2 = (EditText) findViewById(R.id.txtNum2);

        lblResultado =(TextView) findViewById(R.id.lblResultado);

        chkDialog = (CheckBox) findViewById(R.id.chkDialog);

        spnOperacion = (Spinner) findViewById(R.id.spnOperacion);

        CargarSpinner();

    }

    private void CargarSpinner() {
        List<String> operaciones = new ArrayList<>();
        operaciones.add("Sumar");
        operaciones.add("Restar");
        operaciones.add("Multiplicar");
        operaciones.add("Dividir");

        //adaptador xml
        ArrayAdapter<CharSequence> adapterXML = ArrayAdapter.createFromResource(
                this, R.array.operaciones, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        );

        //adaptador listas dinamicas
        ArrayAdapter<String> adapterList = new ArrayAdapter<>(
                this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, operaciones
        );

        //spnOperacion.setAdapter(adapterXML);
        spnOperacion.setAdapter(adapterList);
    }

    public void Calcular(View vista){
        try{
            int num1, num2, res, ope;

            ope = spnOperacion.getSelectedItemPosition();

            num1 = Integer.parseInt(txtNum1.getText().toString());
            num2 = Integer.parseInt(txtNum2.getText().toString());

            switch (ope){
                case 0: res = num1 + num2;
                break;
                case 1: res = num1 - num2;
                break;
                case 2: res = num1 * num2;
                break;
                case 3:
                    if(num2 == 0){
                        res = 0;
                        Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();

                    }else{
                        res = num1 / num2;
                    }
                    break;
                default:res = 0;
                break;
            }

            if (chkDialog.isChecked()){
                Alerta alerta = new Alerta(Integer.toString(res));
                alerta.show(getSupportFragmentManager(), "tag");
            }else{
                lblResultado.setText(Integer.toString(res));
            }
        }catch(Exception e){
            Toast.makeText(this, "Error" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}