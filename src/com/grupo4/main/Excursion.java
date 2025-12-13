package com.grupo4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Excursion {
    private String lugar;            
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int plazas;
    private String dificultad;
    private Montana montana;
    private final List<Expedicionario> expedicionarios;

    public Excursion(Montana montana, LocalDate fechaInicio, LocalDate fechaFin, int plazas) {
        this.montana = montana;
        this.lugar = montana.getNombre();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.plazas = plazas;
        this.dificultad = montana.getDificultad();
        this.expedicionarios = new ArrayList<>();
    }

    public String getLugar() {
        return lugar;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public int getPlazas() {
        return plazas;
    }

    public String getDificultad() {
        return dificultad;
    }

    public Montana getMontana() {
        return montana;
    }

    public List<Expedicionario> getExpedicionarios() {
        return new ArrayList<>(expedicionarios);
    }

    public boolean addExpedicionario(Expedicionario e) {
        if (e == null) return false;
        if (!e.isDisponible()) return false;
        if (expedicionarios.size() >= plazas) return false;
        boolean yaIncluido = expedicionarios.stream().anyMatch(x -> x.getIdExp() == e.getIdExp());
        if (yaIncluido) return false;
        return expedicionarios.add(e);
    }

    @Override
    public String toString() {
        return "Excursion{" +
                "lugar='" + lugar + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", plazas=" + plazas +
                ", dificultad='" + dificultad + '\'' +
                ", montana=" + montana.getNombre() +
                ", inscritos=" + expedicionarios.size() +
                '}';
       }}
