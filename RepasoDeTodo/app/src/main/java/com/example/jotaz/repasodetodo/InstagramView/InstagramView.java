package com.example.jotaz.repasodetodo.InstagramView;

public class InstagramView {

    private String User;
    private String Mensaje;
    private String Hora;

    private int imgUser;


    public InstagramView(String user, String mensaje, String hora, int img)
    {
        User = user;
        Mensaje = mensaje;
        Hora = hora;
        imgUser = img;
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

    public void setImgUser (int imgUser) {
        this.imgUser = imgUser;
    }
}
