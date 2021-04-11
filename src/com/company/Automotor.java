package com.company;

import java.time.LocalDate;
import java.util.*;

public abstract class Automotor {
    private String patente;
    private TipoDeUso tipoDeUso; //particular o profesional
    private Persona propietario;
    private List <Persona> autorizadosAConducir;

    private  LocalDate fechaDeAltaDeAutomotor;
    private  LocalDate fechaDeCambioDePropietario = null;

    public Automotor(String patente, TipoDeUso tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir) {
        this.patente = patente;
        this.tipoDeUso = tipoDeUso;
        this.propietario = propietario;
        this.autorizadosAConducir = autorizadosAConducir;
        this.fechaDeAltaDeAutomotor = LocalDate.now();
    }

    //este constructor es mas que nada para los vehiculos de prueba:
    public Automotor(String patente, TipoDeUso tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir, LocalDate fechaDeAltaDeAutomotor, LocalDate fechaDeCambioDePropietario) {
        this.patente = patente;
        this.tipoDeUso = tipoDeUso;
        this.propietario = propietario;
        this.autorizadosAConducir = autorizadosAConducir;
        this.fechaDeAltaDeAutomotor = fechaDeAltaDeAutomotor;
        this.fechaDeCambioDePropietario = fechaDeCambioDePropietario;
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

    public LocalDate getFechaDeAltaDeAutomotor() {
        return fechaDeAltaDeAutomotor;
    }

    public void setFechaDeAltaDeAutomotor(LocalDate fechaDeAltaDeAutomotor) {
        this.fechaDeAltaDeAutomotor = fechaDeAltaDeAutomotor;
    }

    public LocalDate getFechaDeCambioDePropietario() {
        return fechaDeCambioDePropietario;
    }

    public void setFechaDeCambioDePropietario(LocalDate fechaDeCambioDePropietario) {
        this.fechaDeCambioDePropietario = fechaDeCambioDePropietario;
    }
}
