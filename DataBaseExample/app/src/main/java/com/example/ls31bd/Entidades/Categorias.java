package com.example.ls31bd.Entidades;

public class Categorias {
    private String titulo;
    private int id;

    public Categorias(int i, String t){
        titulo = t;
        id = i;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }
}
