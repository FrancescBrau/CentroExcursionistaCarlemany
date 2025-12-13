package com.grupo4.main;

public class Montana {
    private String nombre;
    private int altitud;
    private String ubicacion;
    private String dificultad;

    public Montana(String nombre, int altitud, String ubicacion, String dificultad) {
        this.nombre = nombre;
        this.altitud = altitud;
        this.ubicacion = ubicacion;
        this.dificultad = dificultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAltitud() {
        return altitud;
    }

    public void setAltitud(int altitud) {
        this.altitud = altitud;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    @Override
    public String toString() {
        return "Montana{" +
                "nombre='" + nombre + '\'' +
                ", altitud=" + altitud +
                ", ubicacion='" + ubicacion + '\'' +
                ", dificultad='" + dificultad + '\'' +
                '}';
    }}
