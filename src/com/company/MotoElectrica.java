package com.company;

import java.time.LocalDate;
import java.util.List;

public class MotoElectrica extends Automotor implements VehiculoElectrico{

    public MotoElectrica(String patente, TipoDeUso tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir);
    }

    public MotoElectrica(String patente, TipoDeUso tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir, LocalDate fechaDeAltaDeAutomotor, LocalDate fechaDeCambioDePropietario) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir, fechaDeAltaDeAutomotor, fechaDeCambioDePropietario);
    }

    @Override
    public void indicarVoltaje() {
        System.out.println("Soy una Moto Eléctrica y tengo un volataje de 220V");
    }
}
