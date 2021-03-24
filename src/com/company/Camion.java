package com.company;

import java.util.List;

public class Camion extends Automotor {
    public Camion(String patente, TipoDeUso tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir);
    }
}
