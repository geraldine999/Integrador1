package com.company;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class ClaseUtilitaria {

    public String asignarPatente(){ //Formato : ABC123
        Random random = new Random();
        int segundaParte = random.nextInt(1000);
        char primeraLetra = (char)(random.nextInt(26) + 'a');
        char segundaLetra = (char)(random.nextInt(26) + 'a');
        char terceraLetra = (char)(random.nextInt(26) + 'a');

        String total = (String.valueOf(primeraLetra) + String.valueOf(segundaLetra) + String.valueOf(terceraLetra)).toUpperCase(Locale.ROOT)
                + String.format("%03d", segundaParte);
        return total;

    }

    public Persona crearPersonaPropietarioOAutorizado(String propietarioOAutorizado){
        Scanner sc = new Scanner(System.in); // TODO este scanner va aca o en atributos de la clase?
        System.out.print("NOMBRE " + propietarioOAutorizado+": ");
        String nombrePropietario = sc.nextLine();
        System.out.println();
        System.out.print("DNI "+propietarioOAutorizado+ ":");
        String dniPropietario = sc.nextLine();
        System.out.println();
        System.out.print("DIRECCION "+ propietarioOAutorizado+": ");
        String direccionPropietario = sc.nextLine();
        Persona persona = new Persona(dniPropietario, nombrePropietario, direccionPropietario);
        return persona;
    }
}
