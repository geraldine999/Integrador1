package com.company;

import java.util.List;

public class Utilitario extends Automotor implements Registrable{
    public Utilitario(String patente, String tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir);
    }
}
