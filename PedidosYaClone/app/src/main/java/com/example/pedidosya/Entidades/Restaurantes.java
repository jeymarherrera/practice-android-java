package com.example.pedidosya.Entidades;

public class Restaurantes {
    private int logo;
    private double rating;
    private int online;

    private String nombre;
    private String direccion;
    private String tiempo;
    private String costo;
    private int favorito;

    public Restaurantes(int l, double r, String n, String d, String t, String c, int f, int o){
        this.logo = l;
        this.rating = r;
        this.nombre = n;
        this.direccion = d;
        this.tiempo = t;
        this.costo = c;
        this.favorito=f;
        this.online = o;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int Online) {
        Online = online;
    }
}
