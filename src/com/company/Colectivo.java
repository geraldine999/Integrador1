package com.company;

import java.util.List;

public class Colectivo extends Automotor {
    public Colectivo(String patente, TipoDeUso tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir);
    }
}
