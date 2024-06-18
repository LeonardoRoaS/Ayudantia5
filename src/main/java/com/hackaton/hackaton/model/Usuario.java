package com.hackaton.hackaton.model;

public class Usuario {
    private String nombre, contraseña, correo, rut;
    private int numero;

    public Usuario(String nombre, String contraseña, String correo, String rut, int numero){
        this.nombre=nombre;
        this.contraseña=contraseña;
        this.correo=correo;
        this.rut = rut;
        this.numero=numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
