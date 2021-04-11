package com.company;

import java.time.LocalDate;
import java.util.List;

public class Utilitario extends Automotor {

    public Utilitario(String patente, TipoDeUso tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir);
    }

    public Utilitario(String patente, TipoDeUso tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir, LocalDate fechaDeAltaDeAutomotor, LocalDate fechaDeCambioDePropietario) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir, fechaDeAltaDeAutomotor, fechaDeCambioDePropietario);
    }
}
