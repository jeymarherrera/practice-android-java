package com.example.ls31bd.Entidades;

public class Pelicula {
    private String Titulo;
    private String Descripcion;
    private int Duracion;
    private float Puntuacion;
    private String Ctaegoria;

    public Pelicula (String titulo, String descripcion, int duracion, float puntuacion, String categoria){
        Puntuacion = puntuacion;
        Titulo = titulo;
        Descripcion = descripcion;
        Duracion = duracion;
        Ctaegoria = categoria;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public int getDuracion() {
        return Duracion;
    }

    public float getPuntuacion() {
        return Puntuacion;
    }

    public String getCtaegoria() {
        return Ctaegoria;
    }
}
