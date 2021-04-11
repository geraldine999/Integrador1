package com.company;

import java.time.LocalDate;
import java.util.List;

public class MotoCombustion extends Automotor implements VehiculoACombustion{

    public MotoCombustion(String patente, TipoDeUso tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir);
    }

    public MotoCombustion(String patente, TipoDeUso tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir, LocalDate fechaDeAltaDeAutomotor, LocalDate fechaDeCambioDePropietario) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir, fechaDeAltaDeAutomotor, fechaDeCambioDePropietario);
    }

    @Override
    public void indicarCapacidadDelTanque() {
        System.out.println("Soy una Moto a Combustion y la capacidad de mi tanque es de 8 litros");
    }
}
