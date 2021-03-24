package com.company;

import jdk.jshell.execution.Util;

import java.util.*;


public class RegistroSeccional {
    private String nombre;
    private List<Automotor> automotoresRegistrados = new ArrayList<>();
    private Set<String> patentes = new TreeSet<>();
    private ClaseUtilitaria objetoUtilitario= new ClaseUtilitaria();


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
       System.out.println("---------------------------------------------");
        for (Automotor auto  : automotoresRegistrados) {
            System.out.print("TIPO DE AUTOMOTOR: " + auto.getClass().getSimpleName() +
                    " PATENTE: " + auto.getPatente() +
                    " TIPO DE USO: " + auto.getTipoDeUso().name().toLowerCase(Locale.ROOT) +
                    " PROPIETARIO: " + auto.getPropietario().getNombre() +
                    " AUTORIZADOS A CONDUCIR: ");
                    for(Persona p: auto.getAutorizadosAConducir()){
                System.out.println(p.getNombre()+ " ");
            }
            System.out.println();
        }
       System.out.println("---------------------------------------------");

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
                    mostrarPropietariosCamionesPorOrdenAlfabetico();
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

    private void mostrarPropietariosCamionesPorOrdenAlfabetico() {
        ArrayList <String> propietariosDeCamiones = new ArrayList<>();
        for (Automotor auto: automotoresRegistrados) {
            if(auto.getClass().getSimpleName().equals("Camion")){
                String propietarioNuevo = auto.getPropietario().getNombre();
                propietariosDeCamiones.add(propietarioNuevo);
            }

        }
        Collections.sort(propietariosDeCamiones);
        System.out.println("---------------------------------------------");
        for (String propietario: propietariosDeCamiones) {
            System.out.println(propietario);

        }
        System.out.println("---------------------------------------------");
    }

    private void registrarAutomotor() {
        String patente= " ";
        //si la patente se repite te genera una nueva hasta que no se repita
        while(patentes.size() == automotoresRegistrados.size()) {
            patente = objetoUtilitario.asignarPatente();
            patentes.add(patente);
        }

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
        System.out.println(" 1 = SI // Otro numero = NO");
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

            default:

                System.out.println("Ok. El automotor no tiene autorizados a conducir");
                break;

        }
        System.out.println("Indique tipo de uso: ");
        TipoDeUso tiposDeUsos[] = TipoDeUso.values();
        for (TipoDeUso tU:tiposDeUsos) {
            System.out.println(tU.getNumeroId() + " :"+ tU.name());

        }
        int numerotipoDeUso = sc3.nextInt();
        TipoDeUso tipoDeUso= TipoDeUso.PARTICULAR;

        for(int i = 0 ; i < tiposDeUsos.length; i++ ){
            if(tiposDeUsos[i].getNumeroId() == numerotipoDeUso ){
                tipoDeUso = tiposDeUsos[i];
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
                automotoresRegistrados.add(motoCombustion);
                break;
            case 4:
                AutoCombustion autoCombustion = new AutoCombustion(patente, tipoDeUso, propietario, autorizadosAConducirList);
                automotoresRegistrados.add(autoCombustion);
                break;
            case 5:
                Colectivo colectivo = new Colectivo(patente, tipoDeUso, propietario, autorizadosAConducirList);
                automotoresRegistrados.add(colectivo);
                break;
            case 6:
                Utilitario utilitario = new Utilitario(patente, tipoDeUso, propietario, autorizadosAConducirList);
                automotoresRegistrados.add(utilitario);
                break;
            case 7:
                Camion camion = new Camion(patente, tipoDeUso, propietario, autorizadosAConducirList);
                automotoresRegistrados.add(camion);
                break;
        }

    }
}
