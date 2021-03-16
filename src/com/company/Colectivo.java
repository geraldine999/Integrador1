package com.company;

import java.util.List;

public class Colectivo extends Automotor implements Registrable{
    public Colectivo(String patente, String tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir);
    }
}
