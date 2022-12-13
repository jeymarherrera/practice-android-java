package com.example.applab5_jherrera_dguerrero_ggordon;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CredencialesActivity extends AppCompatActivity {
    TextView user, id, group, subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credenciales);

        InicializacionControladores();
    }

    private void InicializacionControladores() {
       String nombre="Jeymar", group="1LS131";
    }
}
