package com.example.ls31bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ls31bd.Adapters.ListViewAdapterPeliculas;
import com.example.ls31bd.Datos.PeliculasBDHelper;
import com.example.ls31bd.Entidades.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText titulo, descripcion, duracion, puntuacion;
    ListView lstSF;
    Spinner spnCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InicializarComponentes();
        this.LoadCategorias();
        this.ReloadListview();
    }

    private void InicializarComponentes() {
        titulo = (EditText)findViewById(R.id.txtTitulo);
        descripcion = (EditText)findViewById(R.id.txtDescripcion);
        duracion = (EditText)findViewById(R.id.txtDuracion);
        puntuacion = (EditText)findViewById(R.id.txtRating);

        lstSF = (ListView)findViewById(R.id.lstPelicula);

        spnCat = (Spinner)findViewById(R.id.spnCategorias);
    }

    private void ReloadListview(){
        try {
            PeliculasBDHelper peliculasDb = new PeliculasBDHelper(getApplicationContext(),"Cinepolis",null,R.integer.DBVersion);
            SQLiteDatabase db = peliculasDb.getReadableDatabase();

            List<Pelicula> peliculas = new ArrayList<Pelicula>();

            String[] campos = new String[] {"titulo","descripcion","duracion","puntuacion","categoria_id"};

            Cursor c = db.query("pelicula",campos,null,null,null,null,null);
            if (c.moveToFirst()){
                do {
                    Cursor cat = db.query("categorias",new String[] {"titulo"},"id ="+c.getInt(4),null,null,null,null);
                    String categoria = "";
                    if(cat.moveToFirst()){
                        categoria = cat.getString(0);
                    }

                    Pelicula pelicula = new Pelicula(
                            c.getString(0),
                            c.getString(1),
                            c.getInt(2),
                            c.getFloat(3),
                            categoria
                    );
                    peliculas.add(pelicula);
                }while(c.moveToNext());
            }

            ListViewAdapterPeliculas adapter = new ListViewAdapterPeliculas(getApplicationContext(), peliculas);
            lstSF.setAdapter(adapter);

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Errorcito: "+e.getMessage().toString(),Toast.LENGTH_SHORT).show();
        }
    }

    public void SaveData(View view){
        try {

            String title = titulo.getText().toString();
            String description = descripcion.getText().toString();
            int duration = Integer.parseInt(duracion.getText().toString());
            float rating = Float.parseFloat(puntuacion.getText().toString());
            int categoriaId = spnCat.getSelectedItemPosition()  + 1;

            PeliculasBDHelper peliculasDb = new PeliculasBDHelper(getApplicationContext(),"Cinepolis",null,R.integer.DBVersion);
            SQLiteDatabase db = peliculasDb.getWritableDatabase();

            if (db != null){
                ContentValues values = new ContentValues();
                values.put("titulo",title);
                values.put("descripcion",description);
                values.put("duracion",duration);
                values.put("puntuacion",rating);
                values.put("categoria_id",categoriaId);

                db.insert("pelicula",null,values);
                Toast.makeText(getApplicationContext(),"En teoria, todo se inserto bien",Toast.LENGTH_SHORT).show();
            }
            this.ReloadListview();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Errorcito: "+e.getMessage().toString(),Toast.LENGTH_SHORT).show();
        }
    }

    public void LoadListview(View view){
        this.ReloadListview();
    }

    public void UpdateData(View view){
        try{
            String title = titulo.getText().toString();
            String description = descripcion.getText().toString();
            int duration = Integer.parseInt(duracion.getText().toString());
            float rating = Float.parseFloat(puntuacion.getText().toString());

            PeliculasBDHelper peliculasDb = new PeliculasBDHelper(getApplicationContext(),"Cinepolis",null,R.integer.DBVersion);
            SQLiteDatabase db = peliculasDb.getWritableDatabase();

            if (db != null){
                ContentValues values = new ContentValues();
                values.put("titulo",title);
                values.put("descripcion",description);
                values.put("duracion",duration);
                values.put("puntuacion",rating);

                db.update("pelicula",values,"titulo='"+title+"'",null);
                Toast.makeText(getApplicationContext(),"En teoria, todo se actualizo bien",Toast.LENGTH_SHORT).show();
            }
            this.ReloadListview();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Errorcito: "+e.getMessage().toString(),Toast.LENGTH_SHORT).show();
        }
    }

    public void DeleteData(View view){
        try {
            String title = titulo.getText().toString();
            PeliculasBDHelper peliculasDb = new PeliculasBDHelper(getApplicationContext(),"Cinepolis",null,R.integer.DBVersion);
            SQLiteDatabase db = peliculasDb.getWritableDatabase();

            if (db != null){
                db.delete("pelicula","titulo='"+title+"'",null);
                Toast.makeText(getApplicationContext(),"En teoria, todo se elemino bien",Toast.LENGTH_SHORT).show();
            }
            this.ReloadListview();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Errorcito: "+e.getMessage().toString(),Toast.LENGTH_SHORT).show();
        }
    }

    public void LoadCategorias(){
        try {
            PeliculasBDHelper peliculasDb = new PeliculasBDHelper(getApplicationContext(),"Cinepolis",null,R.integer.DBVersion);
            SQLiteDatabase db = peliculasDb.getWritableDatabase();

            if (db != null){
                db.delete("categorias",null,null);
                 String cat[] = {"Accion","Comedia","Aventura","Terror"};
                 for(int i = 0; i < cat.length; i++){
                    ContentValues c = new ContentValues();
                    c.put("id",i+1);
                    c.put("titulo",cat[i]);
                    db.insert("categorias",null,c);
                 }
                 LoadSpinner();
            }
        }catch (Exception ew){
int x =0;
        }
    }

    public void LoadSpinner(){
        try {
            PeliculasBDHelper peliculasDb = new PeliculasBDHelper(getApplicationContext(),"Cinepolis",null,R.integer.DBVersion);
            SQLiteDatabase db = peliculasDb.getWritableDatabase();

            if (db != null){
                List<String> cat = new ArrayList<String>();

                String[] campos = new String[] {"titulo"};

                Cursor c = db.query("categorias",campos,null,null,null,null,null);
                if (c.moveToFirst()){
                    do {
                        cat.add(c.getString(0));
                    }while(c.moveToNext());
                }

                ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,cat);
                spnCat.setAdapter(adapter);
            }
        }catch (Exception es){

        }
    }

}
