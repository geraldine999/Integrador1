package com.company;

import java.util.List;

public class AutoCombustion extends Automotor implements Registrable{

    public AutoCombustion(String patente, TipoDeUso tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir);
    }


}
