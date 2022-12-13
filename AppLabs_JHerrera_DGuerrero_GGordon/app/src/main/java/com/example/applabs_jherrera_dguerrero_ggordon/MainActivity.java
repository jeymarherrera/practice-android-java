package com.example.applabs_jherrera_dguerrero_ggordon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Esto se imprime desde el metodo OnCreate", Toast.LENGTH_SHORT).show();
    }

    protected void onStart(){
        super.onStart();
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Esto se imprime desde el metodo OnStart", Toast.LENGTH_SHORT).show();
    }

    protected void onRestart(){
        super.onRestart();
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Esto se imprime desde el metodo OnRestart", Toast.LENGTH_SHORT).show();
    }

    protected void onResume(){
        super.onResume();
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Esto se imprime desde el metodo OnResume", Toast.LENGTH_SHORT).show();
    }

    protected void onStop(){
        super.onStop();
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Esto se imprime desde el metodo OnStop", Toast.LENGTH_SHORT).show();
    }

    protected void onDestroy(){
        super.onDestroy();
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Esto se imprime desde el metodo OnDestroy", Toast.LENGTH_SHORT).show();
    }
}