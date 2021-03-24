package com.company;

import java.util.List;

public abstract class Automotor {
    private String patente;
    private TipoDeUso tipoDeUso; //particular o profesional
    private Persona propietario;
    private List <Persona> autorizadosAConducir;

    public Automotor(String patente, TipoDeUso tipoDeUso, Persona propietario, List <Persona> autorizadosAConducir) {
        this.patente = patente;
        this.tipoDeUso = tipoDeUso;
        this.propietario = propietario;
        this.autorizadosAConducir = autorizadosAConducir;
    }

    public String getPatente() {
        return patente;
    }

    public Enum <TipoDeUso> getTipoDeUso() {
        return tipoDeUso;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public List<Persona> getAutorizadosAConducir() {
        return autorizadosAConducir;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }
}
