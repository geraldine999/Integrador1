package com.company;

import java.util.List;

public class MotoCombustion extends Automotor implements Registrable{
    public MotoCombustion(String patente, String tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir);
    }
}