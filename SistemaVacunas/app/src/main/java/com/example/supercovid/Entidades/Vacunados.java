package com.example.supercovid.Entidades;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.supercovid.Helpers.DbHelper;

import java.util.ArrayList;
import java.util.List;

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
        try{
            DbHelper dbHelper = new DbHelper(context,"vacunados");
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            if(db != null){
                String[] campos = new String[]{"id","nombre","cedula","edad","telefono","correo"};
                Cursor cursor = db.query("estudiantes",campos,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do{
                        Estudiantes estudiante = new Estudiantes(
                                cursor.getInt(0),
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getInt(3),
                                cursor.getString(4),
                                cursor.getString(5)
                        );

                        db.close();

                        Vacunas vacuna = this.ObtenerVacunaByEstudiante(estudiante.getId(),context);

                        Vacunados vacunado = new Vacunados(
                                vacuna.getDosis(),
                                vacuna.getEstudiante_id(), //estudiante.getId();
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
            Toast.makeText(context,"Errorcito =>"+e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return vacunados;
    }

    private Vacunas ObtenerVacunaByEstudiante(int estudianteId, Context context){
        try{
            DbHelper dbHelper = new DbHelper(context,"vacunados");
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            if(db != null){
                String[] campos = new String[]{"dosis","chip","estudiante_id"};
                Cursor cursor = db.query("vacunas",campos,"estudiante_id = "+estudianteId,null,null,null,"id DESC","1");
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
            Toast.makeText(context,"Errorcito =>"+e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return new Vacunas();
    }
}
