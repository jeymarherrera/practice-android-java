package com.example.ejemplovacunas.Entidades;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.ejemplovacunas.Helpers.DBHelper;

public class Vacunas {
    private int id;
    private int dosis;
    private String nombre;
    private String fecha;
    private int estudiante_id;
    private int chip;

    public Vacunas() {

    }

    public Vacunas(int i, int d, String n, String f, int e, int chip){
        this.setId(i);
        this.setDosis(d);
        this.setNombre(n);
        this.setFecha(f);
        this.setEstudiante_id(e);
        this.setChip(chip);
    }

    public Vacunas(int dosis, String nombre, String fecha, int estudiante_id, int chip) {
        this.dosis = dosis;
        this.nombre = nombre;
        this.fecha = fecha;
        this.estudiante_id = estudiante_id;
        this.chip=chip;
    }

    public Vacunas(int dosis, int estudiante_id, int chip, String nombre, String cedula, int edad, String telefono, String correo) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(int estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public int getChip() {
        return chip;
    }

    public void setChip(int chip) {
        this.chip = chip;
    }

    public boolean insert(Context context){
        try {
            //validacion de campos nulos o vacios
            DBHelper dbHelper = new DBHelper(context, "vacunados");
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            if(db != null){
                ContentValues content = new ContentValues();
                content.put("dosis", this.getDosis());
                content.put("nombre", this.getNombre());
                content.put("fecha", this.getFecha());
                content.put("Chip", this.getChip());
                content.put("estudiante_id", this.getEstudiante_id());

                db.insert("vacunas", null, content);
                return true;
            }
        }catch (Exception e){
            Toast.makeText(context, "Errorcito en insrcion de estudiantes", Toast.LENGTH_SHORT).show();
        }

        return false;
    }
}
