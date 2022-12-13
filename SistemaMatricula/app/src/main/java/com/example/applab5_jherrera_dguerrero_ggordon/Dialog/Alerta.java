package com.example.applab5_jherrera_dguerrero_ggordon.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class Alerta extends DialogFragment {
    private String resultado;

    public Alerta(String res){
        this.resultado = res;
    }

    public Dialog onCrateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(resultado).setPositiveButton("OK", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
             dialog.cancel();
            }
        });
        return builder.create();
    }
}
