package com.grupo4.main;

public class Alpinista extends Expedicionario {
    private String rango;
    private boolean cima;

    public Alpinista(String nombreExp, int idExp, String experiencia, String alergias, boolean disponibilidad,
                     String rango, boolean cima) {
        super(nombreExp, idExp, experiencia, alergias, disponibilidad);
        this.rango = rango;
        this.cima = cima;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public boolean isCima() {
        return cima;
    }

    public void setCima(boolean cima) {
        this.cima = cima;
    }

    @Override
    public String toString() {
        return super.toString() + ", Alpinista{" +
                "rango='" + rango + '\'' +
                ", cima=" + cima +
                '}';
    }
}

