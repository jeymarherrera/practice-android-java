package com.example.ls31bd.Datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PeliculasBDHelper extends SQLiteOpenHelper {

    String tablePelicula = "CREATE TABLE pelicula(titulo TEXT, descripcion TEXT, duracion INTEGER, puntuacion REAL, categoria_id INTEGER)";
    String tableCategoria = "CREATE TABLE categorias(id INTEGER, titulo TEXT)";

    public PeliculasBDHelper(Context context, String nombre, SQLiteDatabase.CursorFactory cursorFactory, int version){
        super(context,nombre,cursorFactory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablePelicula);
        db.execSQL(tableCategoria);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

}
