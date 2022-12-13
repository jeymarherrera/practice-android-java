package com.example.ejemplovacunas.Helpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.widget.Toast;

import com.example.ejemplovacunas.Entidades.Estudiantes;
import com.example.ejemplovacunas.Entidades.Vacunas;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Vacunados {
    private int dosis;
    private int estudiante_id;
    private int chip;
    private String nombre;
    private String cedula;
    private int edad;
    private String telefono;
    private String correo;

    public Vacunados() {
    }

    public Vacunados(int dosis, int estudiante_id, int chip, String nombre, String cedula, int edad, String telefono, String correo) {
        this.dosis = dosis;
        this.estudiante_id = estudiante_id;
        this.chip = chip;
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
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

    public List<Vacunados> ObtenerListadoVacunados(Context context){
        List<Vacunados> vacunados = new ArrayList<>();
        try {
         DBHelper dbHelper = new DBHelper(context, "vacunados");
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            if(db != null){
                String[] campos = new String[]{"id","nombre","cedula","edad","telefono","correo"};
                Cursor cursor = db.query("estudiante", campos, null, null, null,null, null );
                if(cursor.moveToFirst()){
                    do{
                        Estudiantes estudiante = new Estudiantes(
                                cursor.getInt(0),
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getInt(3),
                                cursor.getString(4),
                                cursor.getString(5)

                                ) ;
                        db.close();
                        Vacunas vacuna = this.ObtenerVacunasByEstudiante(estudiante.getId(), context);
                        Vacunados vacunado = new Vacunados(
                                vacuna.getDosis(),
                                vacuna.getEstudiante_id(),
                                vacuna.getChip(),
                                estudiante.getNombre(),
                                estudiante.getCedula(),
                                estudiante.getEdad(),
                                estudiante.getTelefono(),
                                estudiante.getCorreo()
                        );

                        vacunados.add(vacunado);
                    }while(cursor.moveToNext());
                }
            }

        }catch (Exception e){
            Toast.makeText(context, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return vacunados;
    }

    private Vacunas ObtenerVacunasByEstudiante(int estudiante_id, Context context){
        try {
            DBHelper dbHelper = new DBHelper(context, "vacunados");
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            if(db != null){
                String[] campos = new String[]{"dosis","chip","estudiante_id"};
                Cursor cursor = db.query("vacunas", campos, "estudiante_id = "+estudiante_id, null, null, null, "id DESC", "1");
                if(cursor.moveToFirst()){
                    db.close();
                    return new Vacunas(
                        cursor.getInt(0),
                        "",
                        "",
                        cursor.getInt(2),
                        cursor.getInt(1)
                      );
                }
            }
        }catch (Exception e){
            Toast.makeText(context, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return new Vacunas();
    }
}
