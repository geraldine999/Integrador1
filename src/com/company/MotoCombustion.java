package com.company;

import java.util.List;

public class MotoCombustion extends Automotor {
    public MotoCombustion(String patente, TipoDeUso tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir);
    }
}
