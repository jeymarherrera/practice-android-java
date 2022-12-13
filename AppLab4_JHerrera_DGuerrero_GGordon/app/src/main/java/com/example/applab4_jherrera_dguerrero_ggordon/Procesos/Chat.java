package com.example.applab4_jherrera_dguerrero_ggordon.Procesos;

public class Chat {

    private int foto;
    private String usuario;
    private String mensaje;
    private String hora;

    public Chat (int f, String u, String m, String h){
        setFoto(f);
        setUsuario(u);
        setMensaje(m);
        setHora(h);
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
