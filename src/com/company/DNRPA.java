package com.company;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DNRPA {

    public static void main(String[] args) {
        //TODO corregir Strings tipo de automotor y tipo de uso in listarAutomotores in RegistroSeccional
        //TODO terminar de agregar los try catch?
        //TODO corregir direccion
        //TODO hacer muchas pruebas
        //TODO ver como uso las interfaces




        //Creo una lista de registros seccionales
        List<RegistroSeccional> registrosSeccionales = new ArrayList<>();

        //Agrego 2 registros seccionales
        registrosSeccionales.add(new RegistroSeccional("Tigre"));
        registrosSeccionales.add(new RegistroSeccional("Belgrano"));

        //MENU
        MenuPrincipal menu = new MenuPrincipal();

        //Creo algunos vehiculos de prueba
        //Creo Personas propietarias de todos
        Persona persona = new Persona("56789543", "Jesse Pinkman", "Lavalle 123");
        Persona persona2 = new Persona("345670982", "Tuco Salamanca", "Oxford 456");
        //Una lista de autorizados a conducirlos
        List <Persona> personasAutorizadas = new ArrayList<>();
        personasAutorizadas.add(new Persona("34567123", "Walter White", "El Brujo 567"));
        personasAutorizadas.add(new Persona("12345678", "Werner Heisenberg", "El Paso 666"));

        Camion camion1 = new Camion("ABC123", TipoDeUso.PARTICULAR_DE_USO_PROFESIONAL, persona, personasAutorizadas, LocalDate.of(2013, 4, 5), LocalDate.of(2014, 5, 6));
        Camion camion2 = new Camion("DFG123", TipoDeUso.PARTICULAR, persona2, personasAutorizadas, LocalDate.of(2015, 7, 9), null);
        Camion camion3 = new Camion("ADC356", TipoDeUso.PROFESIONAL, persona2, personasAutorizadas, LocalDate.of(2021,1,1), LocalDate.of(2021,2,2));
        AutoCombustion autoCombustion = new AutoCombustion("QWE421", TipoDeUso.PARTICULAR, persona, personasAutorizadas, LocalDate.of(2000, 5,5), null);


        //Agrego los vehiculos a la  seccional 0 = Tigre
        registrosSeccionales.get(0).getAutomotoresRegistrados().add(camion1);
        registrosSeccionales.get(0).getPatentes().add(camion1.getPatente());

        registrosSeccionales.get(0).getAutomotoresRegistrados().add(camion2);
        registrosSeccionales.get(0).getPatentes().add(camion2.getPatente());

        registrosSeccionales.get(0).getAutomotoresRegistrados().add(camion3);
        registrosSeccionales.get(0).getPatentes().add(camion3.getPatente());

        registrosSeccionales.get(0).getAutomotoresRegistrados().add(autoCombustion);
        registrosSeccionales.get(0).getPatentes().add(autoCombustion.getPatente());
        //LOS VEHICULOS DE PRUEBA ESTAN EN LA SECCIONAL 0 = TIGRE
        //-------------------------------------------------------------------------------------------------------------

        int salir = 0;
        System.out.println();
        System.out.println("BIENVENIDO");
        do{
            int numeroSeccionalElegida = menu.preguntarNumeroSeccionalElegida(registrosSeccionales);
            registrosSeccionales.get(numeroSeccionalElegida).mostrarMenu();
            System.out.println();
            int repetir = 0;
            do{
            System.out.println("DESEA IR A OTRA SECCIONAL?");
            System.out.println("0: SI / OTRO NÚMERO: NO. CERRAR EL PROGRAMA");
            Scanner sc = new Scanner(System.in);
                try {
                    salir = Integer.parseInt(sc.nextLine());
                    repetir = 0;
                } catch (NumberFormatException e) {
                    System.out.println("CARACTER INVALIDO. POR FAVOR INTENTE DE NUEVO");
                    repetir = 1;
                }
        }while(repetir != 0);
        }while(salir ==0);

    }
}
