package com.example.pedidosya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pedidosya.Adapters.RestaurantesListViewAdapter;
import com.example.pedidosya.Entidades.Restaurantes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Restaurantes restaurante;
    ListView lstRestaurantes;
    List<Restaurantes> templist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InicializarControles();
        AttachtEvent();
        PopularDatos(getIntent().getExtras());

    }

    private void PopularDatos(Bundle datos) {
        if(datos!= null){
            restaurante = new Restaurantes(
                    R.drawable.pio, //es .ico no .pio
                    datos.getDouble("rating"),
                    datos.getString("nombre"),
                    datos.getString("lugar"),
                    datos.getString("tiempo"),
                    "$"+datos.getDouble("precio"),
                    0,// falta el corazon
                    datos.getInt("online")
            );

            AnadirNuevoElementoLista(restaurante);

        }else{
            Toast.makeText(this, "Primera Entrada", Toast.LENGTH_SHORT).show();
        }
    }

    private void AnadirNuevoElementoLista(Restaurantes restaurante) {
        List<Restaurantes> listaVieja = ObtenerRestaurantes();
        listaVieja.add(restaurante);

        templist = listaVieja;
        RestaurantesListViewAdapter adapterActualizado = new RestaurantesListViewAdapter(this, listaVieja);
        lstRestaurantes.setAdapter(adapterActualizado);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
       switch (item.getItemId()){

           case R.id.miNew:
               Toast.makeText(this, "Selecciono el menu ", Toast.LENGTH_SHORT).show();
               startActivity(new Intent(this, NuevoRestauranteActivity.class));
               break;

           default:
               return true;
       }
       return true;
    }

    private void InicializarControles(){
        lstRestaurantes = (ListView)findViewById(R.id.lstRestaurantes);
        CargarListView();
    }

    private void AttachtEvent() {
        lstRestaurantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> datos, View view, int pos, long l) {
                List<Restaurantes> todoslosrestaurantes = templist;
                //Restaurantes restauranteSeleccionado = (Restaurantes) datos.getItemAtPosition(pos);
                if(todoslosrestaurantes.get(pos).getFavorito()==1){
                    todoslosrestaurantes.get(pos).setFavorito(0);
                    Toast.makeText(getApplicationContext() , "Hey, has quitado " + todoslosrestaurantes.get(pos).getNombre()+"Como restaurante favorito",Toast.LENGTH_LONG).show();
                }
                else {
                    todoslosrestaurantes.get(pos).setFavorito(1);
                    Toast.makeText(getApplicationContext() , "Hey, has marcado " + todoslosrestaurantes.get(pos).getNombre()+"Como restaurante favorito",Toast.LENGTH_LONG).show();
                }
                Toast.makeText(getApplicationContext() , "Hey, seleccionaste el : "+ pos,Toast.LENGTH_LONG).show();
                RestaurantesListViewAdapter adapteractualizado = new RestaurantesListViewAdapter(getApplicationContext(),todoslosrestaurantes);
                lstRestaurantes.setAdapter(adapteractualizado);
            }
        });
    }

    private void CargarListView(){
        List<Restaurantes> restaurantes = this.ObtenerRestaurantes();
        templist = restaurantes;
        RestaurantesListViewAdapter adapter = new RestaurantesListViewAdapter(this, restaurantes);
        lstRestaurantes.setAdapter(adapter);
    }

    private List<Restaurantes> ObtenerRestaurantes(){
        List<Restaurantes> restaurantes = new ArrayList<Restaurantes>();

        restaurantes.add(new Restaurantes(R.drawable.kfc, 3.5, "KFC", "Changuinola", "40m", "0.99",0, 1));
        restaurantes.add(new Restaurantes(R.drawable.yenu, 5.0, "Rest Yenny", "Condado del Rey", "15m", "0.15",1, 0));
        restaurantes.add(new Restaurantes(R.drawable.mc, 1.0, "McDonalds", "Chiriqui", "360m", "2.50",1, 1));
        restaurantes.add(new Restaurantes(R.drawable.leno, 5.0, "Cafeteria UTP", "Bethania", "1m", "0.01",1, 0));
        restaurantes.add(new Restaurantes(R.drawable.pio, 3.0, "Pio Pio", "Condado del Rey", "30m", "0.99",0, 1));

        return restaurantes;
    }
}