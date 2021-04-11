package com.company;

import java.time.LocalDate;
import java.util.List;

public class AutoElectrico extends Automotor implements VehiculoElectrico{

    public AutoElectrico(String patente, TipoDeUso tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir);
    }

    public AutoElectrico(String patente, TipoDeUso tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir, LocalDate fechaDeAltaDeAutomotor, LocalDate fechaDeCambioDePropietario) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir, fechaDeAltaDeAutomotor, fechaDeCambioDePropietario);
    }

    @Override
    public void indicarVoltaje() {
        System.out.println("Soy un Auto Eléctrico y tengo un voltaje de 400V");
    }
}
