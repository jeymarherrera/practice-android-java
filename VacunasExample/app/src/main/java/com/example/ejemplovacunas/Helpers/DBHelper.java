package com.example.ejemplovacunas.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ejemplovacunas.R;

public class DBHelper extends SQLiteOpenHelper {

    private String estudiante = "CREATE TABLE estudiante (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, cedula TEXT, edad INTEGER, telefono TEXT, correo TEXT)";
    private String vacunas = "CREATE TABLE vacunas (id INTEGER PRIMARY KEY AUTOINCREMENT, dosis INTEGER, nombre TEXT, fecha TEXT,chip INTEGER, estudiante_id INTEGER)";

    public DBHelper(Context context, String dbName){
        super(context, dbName, null, R.integer.db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(estudiante);
        db.execSQL(vacunas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
