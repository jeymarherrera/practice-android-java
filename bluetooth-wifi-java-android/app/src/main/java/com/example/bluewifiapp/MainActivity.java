package com.example.bluewifiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goWifi(View v){
        Intent itn = new Intent(this, WifiActivity.class);
        startActivity(itn);
    }

    public void goBluet(View v){
        Intent itn = new Intent(this, BluethootAcitvity.class);
        startActivity(itn);
    }
}