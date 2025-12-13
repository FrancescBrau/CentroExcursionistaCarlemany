package com.grupo4.main;

public class Medico extends Expedicionario {
    private String idColegiado;
    private String especialista;

    public Medico(String nombreExp, int idExp, String experiencia, String alergias, boolean disponibilidad,
                  String idColegiado, String especialista) {
        super(nombreExp, idExp, experiencia, alergias, disponibilidad);
        this.idColegiado = idColegiado;
        this.especialista = especialista;
    }

    public String getIdColegiado() {
        return idColegiado;
    }

    public void setIdColegiado(String idColegiado) {
        this.idColegiado = idColegiado;
    }

    public String getEspecialista() {
        return especialista;
    }

    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }

    @Override
    public String toString() {
        return super.toString() + ", Medico{" +
                "idColegiado='" + idColegiado + '\'' +
                ", especialista='" + especialista + '\'' +
                '}';
    }
}

