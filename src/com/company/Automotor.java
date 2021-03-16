package com.company;

import java.util.List;

public abstract class Automotor {
    public static final String NOMBRECLASE = " ";
    private String patente;
    private String tipoDeUso; //particular o profesional
    private Persona propietario;
    private List <Persona> autorizadosAConducir;

    public Automotor(String patente, String tipoDeUso, Persona propietario, List <Persona> autorizadosAConducir) {
        this.patente = patente;
        this.tipoDeUso = tipoDeUso;
        this.propietario = propietario;
        this.autorizadosAConducir = autorizadosAConducir;
    }

    public String getPatente() {
        return patente;
    }

    public String getTipoDeUso() {
        return tipoDeUso;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public List<Persona> getAutorizadosAConducir() {
        return autorizadosAConducir;
    }


}
