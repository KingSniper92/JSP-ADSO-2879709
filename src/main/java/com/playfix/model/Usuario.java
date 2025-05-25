package com.playfix.model;

public class Usuario {

    private int idUsuario;
    private String nombreUsuario;
    private String mailUsuario;
    private String telefonoUsuario;

    public Usuario(int idUsuario, String nombreUsuario, String mailUsuario, String telefonoUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.mailUsuario = mailUsuario;
        this.telefonoUsuario = telefonoUsuario;
    }

    public int getIdUsuario() { return idUsuario; }
    public String getNombreUsuario() { return nombreUsuario; }
    public String getMailUsuario() { return mailUsuario; }
    public String getTelefonoUsuario() { return telefonoUsuario; }

}
