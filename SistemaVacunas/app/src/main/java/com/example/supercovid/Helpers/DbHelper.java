package com.example.supercovid.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.supercovid.R;

public class DbHelper extends SQLiteOpenHelper {

    private String estudiantes = "CREATE TABLE estudiantes (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,cedula TEXT, edad INTEGER, telefono TEXT, correo TEXT)";
    private String vacunas = "CREATE TABLE vacunas (id INTEGER PRIMARY KEY AUTOINCREMENT, dosis INTEGER, nombre TEXT, fecha TEXT, chip INTEGER, estudiante_id INTEGER)";

    public DbHelper(Context context, String dbName){
        super(context,dbName,null, R.integer.db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(estudiantes);
        sqLiteDatabase.execSQL(vacunas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
