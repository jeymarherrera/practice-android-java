package com.example.lab_sff_3.apptaller1_jherrera_ggordon_dguerrero.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class Alerta extends DialogFragment {
        private String res;
    public Alerta(String r){this.res=r;}
        @Override
        public Dialog onCreateDialog( Bundle savedInstanceState){
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            if(res.equals("Profesor")) {
                builder.setTitle("Error").setMessage("El Profesor no puede entrar").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
            }
            else {
                builder.setTitle("Error").setMessage("El Estudiante no puede entrar").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

            }


            return builder.create();
        }

    }
