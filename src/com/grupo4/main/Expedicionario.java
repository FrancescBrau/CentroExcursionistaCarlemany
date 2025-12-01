
package com.grupo4.main;

public class Expedicionario {
    private String nombreExp;
    private int idExp;
    private String experiencia;
    private String alergias;
    private boolean disponibilidad;

    public Expedicionario(String nombreExp, int idExp, String experiencia, String alergias, boolean disponibilidad) {
        this.nombreExp = nombreExp;
        this.idExp = idExp;
        this.experiencia = experiencia;
        this.alergias = alergias;
        this.disponibilidad = disponibilidad;
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public int getIdExp() {
        return idExp;
    }

    public void setIdExp(int idExp) {
        this.idExp = idExp;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public boolean isDisponible() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Expedicionario{" +
                "nombre='" + nombreExp + '\'' +
                ", id=" + idExp +
                ", experiencia='" + experiencia + '\'' +
                ", alergias='" + alergias + '\'' +
                ", disponible=" + disponibilidad +
                '}';
       }}
