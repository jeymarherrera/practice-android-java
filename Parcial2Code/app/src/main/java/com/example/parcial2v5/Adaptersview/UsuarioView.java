package com.example.parcial2v5.Adaptersview;

public class UsuarioView {

    private String User;
    private String Mensaje;
    private String Hora;
    private int favorito;
    private int imgUser;
    private int tipo;




    public UsuarioView(String user, String mensaje, String hora, int img , int f)
    {
        setUser(user);
        setMensaje(mensaje);
        setHora(hora);
        setImgUser(img);
        setFavorito( f);
    }



    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public int getImgUser() {
        return imgUser;
    }

    public void setImgUser(int imgUser) {
        this.imgUser = imgUser;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
