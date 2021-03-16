package com.company;

import java.util.List;

public class AutoElectrico extends Automotor implements Registrable{
    public static final String NOMBRECLASE = "Auto Electrico";
    public AutoElectrico(String patente, String tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir);
    }
}
