package com.company;

import java.time.LocalDate;
import java.util.List;

public class Camion extends Automotor implements VehiculoACombustion{

    public Camion(String patente, TipoDeUso tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir);
    }

    public Camion(String patente, TipoDeUso tipoDeUso, Persona propietario, List<Persona> autorizadosAConducir, LocalDate fechaDeAltaDeAutomotor, LocalDate fechaDeCambioDePropietario) {
        super(patente, tipoDeUso, propietario, autorizadosAConducir, fechaDeAltaDeAutomotor, fechaDeCambioDePropietario);
    }

    @Override
    public void indicarCapacidadDelTanque() {
        System.out.println("Soy un Camion y la capacidad de mi tanque es de 500 litros");
    }
}
