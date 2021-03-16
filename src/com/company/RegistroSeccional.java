package com.company;

import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RegistroSeccional {
    private String nombre;
    private List<Automotor> automotoresRegistrados = new ArrayList<>();

    public RegistroSeccional(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Automotor> getAutomotoresRegistrados() {
        return automotoresRegistrados;
    }

   public void listarAutomotores() {
        for (Automotor auto  : automotoresRegistrados) {
            System.out.print("Tipo de automotor: " + auto.NOMBRECLASE +
                    " / Patente: " + auto.getPatente() +
                    " / Tipo de uso: " + auto.getTipoDeUso() +
                    " / Propietario: " + auto.getPropietario().getNombre() +
                    " / Autorizados a conducir : ");
                    for(Persona p: auto.getAutorizadosAConducir()){
                System.out.println(p.getNombre()+ " ");
            }
        }

    }

    public void mostrarMenu() {
        int salir = 0;
        Scanner sc2 = new Scanner(System.in);
        do {
            System.out.println("1= Registrar automotor");
            System.out.println("2= Listar automotores registrados en la seccional");
            System.out.println("3= Listar a todos los propietarios de camiones en orden alfabético");
            System.out.println("4= Modificar el propietario de un automotor");
            System.out.println("5= Consultar si pasó 1 año o más desde el registro de un automotor");
            System.out.println("0 = Salir");
            System.out.print("Indique la opción deseada: ");
            int opcion = sc2.nextInt();
            switch (opcion) {
                case 1:
                    registrarAutomotor();
                    break;
                case 2:
                    listarAutomotores();
                    break;
                case 3:
                    //mostrarPropietariosCamionesPorOrdenAlfabetico();
                    break;
                case 4:
                    //modificarElPropietarioDeUnAutomotor();
                    break;
                case 5:
                    //consultarSiPaso1AnioOMasDesdeElRegistroDeUnAuto();
                    break;
                case 0:
                    salir = 1;
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo");
            }
        }while(salir == 0);
    }

    private void registrarAutomotor() {
        String patente = "1"; //OJO CON ESTO!
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Qué tipo de automotor desea registrar?");
        System.out.println("1 = Moto Eléctrica 2= Auto Eléctrico 3= Moto Combustión");
        System.out.println("4 = Auto Combustión 5 = Colectivo 6 = Utilitario 7= Camión ");
        int opcionTipoAutomotor = sc3.nextInt();
        sc3.nextLine();// limpiar buffer
        System.out.print("Nombre propietario: ");
        String nombrePropietario = sc3.nextLine();
        System.out.println();
        System.out.print("DNI propietario: ");
        String dniPropietario = sc3.nextLine();
        System.out.println();
        System.out.print("Dirección propietario: ");
        String direccionPropietario = sc3.nextLine();
        Persona propietario = new Persona(dniPropietario, nombrePropietario, direccionPropietario, true);
        System.out.println("Agregar autorizados a conducir? ");
        System.out.println(" 1 = SI // 2 = NO");
        List <Persona > autorizadosAConducirList = new ArrayList<>();
        int autorizadosAConducir = sc3.nextInt();
        switch(autorizadosAConducir){
            case 1:
                sc3.nextLine();// limpiar buffer
                int otraVez = 0;
                do {
                    System.out.print("Nombre autorizado: ");
                    String nombreAutorizado = sc3.nextLine();
                    System.out.println();
                    System.out.print("DNI autorizado: ");
                    String dniAutorizado = sc3.nextLine();
                    System.out.println();
                    System.out.print("Dirección autorizado: ");
                    String direccionAutorizado = sc3.nextLine();
                    autorizadosAConducirList.add(new Persona(dniAutorizado, nombreAutorizado, direccionAutorizado, false));
                    System.out.println("Agregar otra persona autorizada?");
                    System.out.println("0= SI // Otro numero = NO");
                    otraVez = sc3.nextInt();
                }while(otraVez == 0);
                break;

            case 2:

                System.out.println("Ok. El automotor no tiene autorizados a conducir");
                break;

        }
        System.out.println("Indique tipo de uso: ");
        System.out.println(" 1= Particular // 2= Profesional");
        String tipoDeUso = " ";
        int numerotipoDeUso = sc3.nextInt();
        int salirSwitch = 0;

        while(salirSwitch == 0){
            switch (numerotipoDeUso) {
                case 1:
                    tipoDeUso = "Particular";
                    salirSwitch = 1;
                    break;

                case 2:
                    tipoDeUso = "Profesional";
                    salirSwitch = 1;
                    break;

                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo");

            }
        }

        switch (opcionTipoAutomotor){
            case 1:
                MotoElectrica motoElectrica = new MotoElectrica(patente, tipoDeUso, propietario, autorizadosAConducirList);
                automotoresRegistrados.add(motoElectrica);
                break;
            case 2:
                AutoElectrico autoElectrico = new AutoElectrico(patente, tipoDeUso, propietario, autorizadosAConducirList);
                automotoresRegistrados.add(autoElectrico);
                break;
            case 3:
                MotoCombustion motoCombustion = new MotoCombustion(patente, tipoDeUso, propietario, autorizadosAConducirList);
                //automotoresRegistrados.add(motoCombustion);
                break;
            case 4:
                AutoCombustion autoCombustion = new AutoCombustion(patente, tipoDeUso, propietario, autorizadosAConducirList);
                //automotoresRegistrados.add(autoCombustion);
                break;
            case 5:
                Colectivo colectivo = new Colectivo(patente, tipoDeUso, propietario, autorizadosAConducirList);
                //automotoresRegistrados.add(colectivo);
                break;
            case 6:
                Utilitario utilitario = new Utilitario(patente, tipoDeUso, propietario, autorizadosAConducirList);
                //automotoresRegistrados.add(utilitario);
                break;
            case 7:
                Camion camion = new Camion(patente, tipoDeUso, propietario, autorizadosAConducirList);
                //automotoresRegistrados.add(camion);
                break;
        }

    }
}
