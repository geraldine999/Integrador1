package com.company;

import java.util.List;

public class AutoElectrico extends Automotor implements Registrable{

    public AutoElectrico(String patente, TipoDeUso tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir);
    }


}
