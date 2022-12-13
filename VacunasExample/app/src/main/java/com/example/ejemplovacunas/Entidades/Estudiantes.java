package com.example.ejemplovacunas.Entidades;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.ejemplovacunas.Helpers.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class Estudiantes {
    private int id;
    private String nombre;
    private String cedula;
    private int edad;
    private String telefono;
    private String correo;

    public Estudiantes(int i, String n, String c, int e, String t, String co){
        this.setId(i);
        this.setNombre(n);
        this.setCedula(c);
        this.setEdad(e);
        this.setTelefono(t);
        this.setCorreo(co);
    }

    public Estudiantes(String n, String c, int e, String t, String co){
        this.setNombre(n);
        this.setCedula(c);
        this.setEdad(e);
        this.setTelefono(t);
        this.setCorreo(co);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean insert(Context context){
        try {
            //validacion de campos nulos o vacios
            DBHelper dbHelper = new DBHelper(context, "vacunados");
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            if(db != null){
                ContentValues content = new ContentValues();
                content.put("nombre", this.getNombre());
                content.put("cedula", this.getCedula());
                content.put("edad", this.getEdad());
                content.put("telefono", this.getTelefono());
                content.put("correo", this.getCorreo());

                db.insert("estudiante", null, content);
                return true;
            }
        }catch (Exception e){
            Toast.makeText(context, "Errorcito en insrcion de estudiantes", Toast.LENGTH_SHORT).show();
        }

        return false;
    }

    public List<String> ObtenerNombreEstudiantes(Context context){
        List<String> nombreEstudiantes = new ArrayList<>();
        try {
            //validacion de campos nulos o vacios
            DBHelper dbHelper = new DBHelper(context, "vacunados");
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            if(db != null){
                String[] campos = new String[]{"nombre", "id"};
                Cursor cursor = db.query("estudiante", campos, null, null, null, null, null);

                if(cursor.moveToFirst()){
                    do {
                        nombreEstudiantes.add(cursor.getInt(1)+"-"+cursor.getString(0));
                    }while (cursor.moveToNext());
                }
            }
        }catch (Exception e){
            Toast.makeText(context, "Errorcito en el select"+ e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return  nombreEstudiantes;
    }

    public Estudiantes(){}
}
