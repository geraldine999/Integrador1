package com.company;

import java.util.List;

public class MotoElectrica extends Automotor {
    public MotoElectrica(String patente, TipoDeUso tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir);
    }
}
