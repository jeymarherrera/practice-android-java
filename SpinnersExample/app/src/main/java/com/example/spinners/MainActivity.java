package com.example.spinners;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);

        final Spinner spinner = (Spinner) findViewById(R.id.testSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Months);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final Button changeButton = (Button) findViewById(R.id.enableButton);
        changeButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                changeOption(spinner);
            }
        });
        final Button changeButton2 = (Button) findViewById(R.id.backgroundColorButton);
        changeButton2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                changeOption2(spinner);

            }
        });
    }

    static final String[] Months = new String[] { "January", "February",
            "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };

    public void changeOption(Spinner spinner) {
        if (spinner.isEnabled()) {
            spinner.setEnabled(false);
        } else {
            spinner.setEnabled(true);

        }
    }

    public void changeOption2(Spinner spinner) {
        spinner.setBackgroundColor(Color.RED);
    }
}