package com.company;

import java.util.List;

public class Utilitario extends Automotor {
    public Utilitario(String patente, TipoDeUso tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir);
    }
}
