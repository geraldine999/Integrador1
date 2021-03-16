package com.company;

import java.util.List;

public class AutoCombustion extends Automotor implements Registrable{

    public static final String NOMBRECLASE = "Auto Combustion";
    public AutoCombustion(String patente, String tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir);
    }


}
