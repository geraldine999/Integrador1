package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class RegistroSeccional {
    private String nombre;
    private List<Automotor> automotoresRegistrados = new ArrayList<>();
    private Set<String> patentes = new TreeSet<>();


    public RegistroSeccional(String nombre) {
        this.nombre = nombre;
    }

    public Set<String> getPatentes() {
        return patentes;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Automotor> getAutomotoresRegistrados() {
        return automotoresRegistrados;
    }

    public void mostrarMenu() {
        int salir = 0;
        Scanner sc2 = new Scanner(System.in);
        do {
            System.out.println("1= Registrar automotor");
            System.out.println("2= Listar automotores registrados en la seccional desde cierta fecha");
            System.out.println("3= Listar a todos los propietarios de camiones en orden alfabético");
            System.out.println("4= Modificar el propietario de un automotor (La fecha de cambio quedará registrada)");
            System.out.println("5= Consultar si pasó 1 año o más desde el registro de un automotor o desde el cambio de su propietario");
            System.out.println("6= Listar por tipo de automotor");
            System.out.println("0 = Salir de esta seccional");
            System.out.print("Indique la opción deseada: ");
            int opcion = Integer.parseInt(sc2.nextLine());
            System.out.println();
            switch (opcion) {
                case 1:
                    registrarAutomotor();
                    break;
                case 2:
                    listarAutomotoresDesdeCiertaFecha();
                    break;
                case 3:
                    mostrarPropietariosCamionesPorOrdenAlfabetico();
                    break;
                case 4:
                    modificarElPropietarioDeUnAutomotorYRegistarLaFecha();
                    break;
                case 5:
                    consultarSiPaso1AnioOMasDesdeElRegistroDeUnAutoOCambioDeTitular();
                    break;
                case 6:
                    listarVehiculosPorTipoDeAutomotor();
                    break;
                case 0:
                    salir = 1;
                    break;
                default:
                    System.out.println("OPCIÓN INVÁLIDA, INTENTE DE NUEVO");
            }
        } while (salir == 0);
    }

    private void listarVehiculosPorTipoDeAutomotor() {
        int opcionTipoAutomotor = indicarTipoDeAutomotor();
        String nombreClase = "";
        switch(opcionTipoAutomotor){
            case 1:
                nombreClase = "MotoElectrica";
                break;
            case 2:
                nombreClase = "AutoElectrico";
                break;
            case 3:
                nombreClase = "MotoCombustion";
                break;
            case 4:
                nombreClase = "AutoCombustion";
                break;
            case 5:
                nombreClase = "Colectivo";
                break;
            case 6:
                nombreClase = "Utilitario";
                break;
            case 7:
                nombreClase = "Camion";
                break;

        }
        for(Automotor auto : automotoresRegistrados){
            if(auto.getClass().getSimpleName().equals(nombreClase)){
                mostrarCaracteristicasDelAutomotor(auto);
            }
        }


    }


    public void listarAutomotoresDesdeCiertaFecha() {
        //LIMITAR LOS VEHICULOS QUE SE MUESTRAN POR FECHA
        int deNuevo2 = 1;
        Scanner sc = new Scanner(System.in);
        int anio = 1;
        do {
            System.out.println("INDIQUE DESDE QUE FECHA DESEA VER LOS VEHÍCULOS REGISTRADOS:");
            System.out.print("AÑO:");
            try {
                anio = Integer.parseInt(sc.nextLine());
                if (anio > LocalDate.now().getYear()) {
                    System.out.println("EL AÑO INGRESADO NO PUEDE SER MAYOR AL AÑO ACTUAL");
                } else {
                    deNuevo2 = 0;
                }

            } catch (NumberFormatException e) {
                System.out.println("VALOR INGRESADO INVÁLIDO. POR FAVOR INTENTE DE NUEVO");
            }
        } while (deNuevo2 == 1);
        System.out.println("---------------------------------------------");
        for (Automotor auto : automotoresRegistrados) {
            if (auto.getFechaDeAltaDeAutomotor().getYear() >= anio) {
                mostrarCaracteristicasDelAutomotor(auto);
            }
        }
    }

    public void mostrarCaracteristicasDelAutomotor(Automotor auto){

                System.out.print("TIPO DE AUTOMOTOR: " + auto.getClass().getSimpleName() +
                        " PATENTE: " + auto.getPatente() +
                        " TIPO DE USO: " + auto.getTipoDeUso().name().toLowerCase(Locale.ROOT) +
                        " PROPIETARIO: " + auto.getPropietario().getNombre() +
                        " AUTORIZADOS A CONDUCIR: ");
                for (Persona p : auto.getAutorizadosAConducir()) {
                    System.out.println(p.getNombre() + " ");
                }

                System.out.println("FECHA DE ALTA: " + auto.getFechaDeAltaDeAutomotor().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
                System.out.println();

                System.out.println("---------------------------------------------");
            }





    public void mostrarPropietariosCamionesPorOrdenAlfabetico() {
        ArrayList<String> propietariosDeCamiones = new ArrayList<>();
        for (Automotor auto : automotoresRegistrados) {
            if (auto.getClass().getSimpleName().equals("Camion")) {
                String propietarioNuevo = auto.getPropietario().getNombre().toUpperCase(Locale.ROOT);
                if(!propietariosDeCamiones.contains(propietarioNuevo)){
                    propietariosDeCamiones.add(propietarioNuevo);
                }

            }

        }
        Collections.sort(propietariosDeCamiones);
        System.out.println("---------------------------------------------");
        for (String propietario : propietariosDeCamiones) {
            System.out.println(propietario);

        }
        System.out.println("---------------------------------------------");
    }

    public void registrarAutomotor() {
        String patente = " ";
        //si la patente se repite te genera una nueva hasta que no se repita
        while (patentes.size() == automotoresRegistrados.size()) {
            patente = generarPatente();
            patentes.add(patente);
        }

        int opcionTipoAutomotor = indicarTipoDeAutomotor();
        Scanner sc3 = new Scanner(System.in);

        Persona propietario = crearPersonaPropietarioOAutorizado("PROPIETARIO");

        System.out.println("AGREGAR AUTORIZADOS A CONDUCIR? ");
        System.out.println(" 1 = SI // OTRO NÚMERO = NO");
        List<Persona> autorizadosAConducirList = new ArrayList<>();

        int autorizadosAConducir = Integer.parseInt(sc3.nextLine());
        switch (autorizadosAConducir) {
            case 1:
                int otraVez = 0;
                do {
                    Persona autorizado = crearPersonaPropietarioOAutorizado("AUTORIZADO");
                    autorizadosAConducirList.add(autorizado);
                    System.out.println("AGREGAR OTRA PERSONA AUTORIZADA?");
                    System.out.println("0= SI // OTRO NÚMERO = NO");
                    otraVez = Integer.parseInt(sc3.nextLine());
                } while (otraVez == 0);
                break;

            default:

                System.out.println("OK. EL AUTOMOTOR NO TIENE AUTORIZADOS A CONDUCIR");
                break;

        }
        int deVuelta = 0;

        TipoDeUso tipoDeUso = TipoDeUso.PARTICULAR;
        do {
            System.out.println("INDIQUE TIPO DE USO: ");
            TipoDeUso tiposDeUsos[] = TipoDeUso.values();
            for (TipoDeUso tU : tiposDeUsos) {
                System.out.println(tU.ordinal() + " :" + tU.name());
            }
            int numerotipoDeUso = Integer.parseInt(sc3.nextLine());

            if (numerotipoDeUso > TipoDeUso.values().length - 1 || numerotipoDeUso < 0) {
                System.out.println("NÚMERO DE USO INCORRECTO. POR FAVOR INTENTE DE NUEVO");
            } else {
                tipoDeUso = TipoDeUso.values()[numerotipoDeUso];
                deVuelta = 1;
            }
        } while (deVuelta == 0);


        switch (opcionTipoAutomotor) {
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

    public int indicarTipoDeAutomotor() {
        Scanner sc3 = new Scanner(System.in);
        int deNuevo = 1;
        int opcionTipoAutomotor = 1;
        do {
            System.out.println("INDIQUE EL TIPO DE AUTOMOTOR");
            System.out.println("1 = Moto Eléctrica 2= Auto Eléctrico 3= Moto Combustión");
            System.out.println("4 = Auto Combustión 5 = Colectivo 6 = Utilitario 7= Camión ");
            try {
                opcionTipoAutomotor = Integer.parseInt(sc3.nextLine());
                if (opcionTipoAutomotor > 7 || opcionTipoAutomotor < 1) {
                    System.out.println("NÚMERO INVÁLIDO, POR FAVOR INTENTE DE NUEVO");
                }else{
                    deNuevo =0;
                }
            } catch (NumberFormatException e) {
                System.out.println("CARACTER INVÁLIDO, POR FAVOR INTENTE DE NUEVO");
            }
        }while(deNuevo ==1);
        return opcionTipoAutomotor;
    }


    public String listarVehiculosPorPatentePreguntarAlUsuarioPatenteValidarlaYDevolverla(String accion) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------------------------------");
        listarAutomotoresDesdeCiertaFecha();
        int deNuevo = 1;
        String patente = "";
        do {
            System.out.print("ESCRIBA LA PATENTE DEL VEHÍCULO A " + accion);
            patente = sc.nextLine().toUpperCase(Locale.ROOT);
            if (!patentes.contains(patente)) {
                System.out.println("NO SE ENCONTRÓ ESA PATENTE");
                System.out.println("-----------------------------------------------------------");
            }else{
                deNuevo = 0;
            }
        } while (deNuevo == 1);
        return patente;
    }

    public Boolean pasoMasde1AnioDesdeElRegistroDeUnAuto(String patente) {
        Boolean masDe1Anio = false;
        for (Automotor auto :
                automotoresRegistrados) {
            if (patente.equals(auto.getPatente())) {
                LocalDate fechaDeAlta = auto.getFechaDeAltaDeAutomotor();
                LocalDate fechaActual = LocalDate.now();
                if (fechaDeAlta.plusDays(365).isBefore(fechaActual)) {
                    masDe1Anio = true;
                }
            }
        }
        return masDe1Anio;
    }

    public Boolean pasoMasde1AnioDesdeElCambioDeTitular(String patente) {
        Boolean masDe1Anio = false;
        for (Automotor auto :
                automotoresRegistrados) {
            if (patente.equals(auto.getPatente())) {
                LocalDate fechaDeCambio = auto.getFechaDeCambioDePropietario();
                LocalDate fechaActual = LocalDate.now();
                if(fechaDeCambio != null){
                    if (fechaDeCambio.plusDays(365).isBefore(fechaActual)) {
                        masDe1Anio = true;
                    }
                }

            }
        }
        return masDe1Anio;
    }


    public void consultarSiPaso1AnioOMasDesdeElRegistroDeUnAutoOCambioDeTitular() {
        String patente = listarVehiculosPorPatentePreguntarAlUsuarioPatenteValidarlaYDevolverla("A CONSULTAR: ");
        if (pasoMasde1AnioDesdeElRegistroDeUnAuto(patente)) {
            System.out.println("PASÓ MÁS DE UN AÑO DESDE QUE SE DIÓ DE ALTA ESTE AUTOMOTOR ");

        } else {
            System.out.println("NO PASÓ MÁS DE UN AÑO DESDE QUE SE DIÓ DE ALTA ESTE AUTOMOTOR");
        }
        if (pasoMasde1AnioDesdeElCambioDeTitular(patente)) {
            System.out.println("PASÓ MÁS DE UN AÑO DESDE QUE SE CAMBIÓ DE TITULAR POR ÚLTIMA VEZ, POR LO QUE SE PUEDE VOLVER A CAMBIAR DE TITULAR");
        } else {
            for (Automotor auto : automotoresRegistrados) {
                if (auto.getPatente().equals(patente)) {
                    if (auto.getFechaDeCambioDePropietario() == null) {
                        System.out.println("NUNCA SE CAMBIÓ DE PROPIETARIO");
                    }else {
                        System.out.println("NO PASÓ MAS DE UN AÑO DESDE QUE SE CAMBIÓ DE PROPIETARIO POR ÚLTIMA VEZ");
                    }
                }

            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
    }

    public void modificarElPropietarioDeUnAutomotorYRegistarLaFecha() {
        String patente = listarVehiculosPorPatentePreguntarAlUsuarioPatenteValidarlaYDevolverla("MODIFICAR EL PROPIETARIO: ");
        for (Automotor auto :
                automotoresRegistrados) {
            if (patente.equals(auto.getPatente())) {
                //Condiciones para que cambie: si se cambio de propietario alguna vez y ademas paso mas de un anio desde ese cambio
                //O nunca se cambio de propietario en primer lugar
                if ((auto.getFechaDeCambioDePropietario() != null && pasoMasde1AnioDesdeElCambioDeTitular(patente)) || (auto.getFechaDeCambioDePropietario() == null)) {
                    Persona nuevoPropietario = crearPersonaPropietarioOAutorizado("DEL NUEVO PROPIETARIO");
                    auto.setPropietario(nuevoPropietario);
                    System.out.println("LISTO, AHORA EL NUEVO PROPIETARIO DEL VEHÍCULO CON LA PATENTE " + patente + " ES " + nuevoPropietario.getNombre());
                    //cambiar fecha
                    auto.setFechaDeCambioDePropietario(LocalDate.now());
                    System.out.println("LA FECHA DE CAMBIO DE PROPIETARIO QUEDÓ REGISTRADA: " + auto.getFechaDeCambioDePropietario().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
                }else {
                    System.out.println("NO SE PUEDE MODIFICAR EL PROPIETARIO DE ESE VEHÍCULO PORQUE TODAVÍA NO PASÓ MÁS DE UN AÑO DESDE QUE SE REGISTRÓ");
                    System.out.println("---------------------------------------------------------------------------------------------------------------");
                }
            }
        }

    }

    public String generarPatente(){ //Formato : ABC123
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
        Scanner sc = new Scanner(System.in);
        String nombre = "";
        String dni = "";
        String direccion = "";

        int deNuevo = 1;
        do {
            System.out.print("NOMBRE " + propietarioOAutorizado + ": ");
            nombre = sc.nextLine();
            if (nombre.matches("((([a-zA-Z]+[ ]*)+){3,45})")) {
                deNuevo = 0;

            }else{
                System.out.println("EL NOMBRE NO PUEDE ESTAR VACÍO, DEBE CONTENER ENTRE 3 Y 45 CARACTERES Y NO DEBE TENER NÚMEROS NI CARACTERES ESPECIALES");
                System.out.println("POR FAVOR INTENTE DE NUEVO");
            }
        }while(deNuevo == 1);

        System.out.println();
        deNuevo = 1;
        do {
            System.out.print("DNI " + propietarioOAutorizado + ":");
            dni = sc.nextLine();
            if (dni.matches("([0-9]){8}")) {
                deNuevo =0;
            }else{
                System.out.println("EL DNI NO PUEDE ESTAR VACÍO, DEBE CONTENER 8 NÚMEROS Y NO DEBE TENER LETRAS NI CARACTERES ESPECIALES");
                System.out.println("POR FAVOR INTENTE DE NUEVO");
            }
        }while(deNuevo ==1);
        System.out.println();
        int deNuevo2 = 1;
        int deNuevo3 = 1;
        String calle ="";
        String numero="";
        do {
            System.out.println("DIRECCIÓN " + propietarioOAutorizado+ " :" );
            do{
                System.out.print("CALLE: ");
                calle = sc.nextLine();
                if(calle.matches("([a-zA-Z0-9]+[ ]*)+")){
                    deNuevo2 =0;
                }else{
                    System.out.println("EL NOMBRE DE LA CALLE NO PUEDE TENER CARACTERES ESPECIALES NI ESTAR VACÍO");
                    System.out.println("POR FAVOR INTENTE DE NUEVO");
                }
            } while(deNuevo2 ==1);
            do {
                System.out.print("NÚMERO: ");
                numero = sc.nextLine();
                if (numero.matches("[0-9]+")) {
                    deNuevo3 = 0;


                } else {
                    System.out.println("EL NÚMERO NO PUEDE ESTAR VACÍO, NO PUEDE TENER CARACTERES ESPECIALES NI LETRAS");
                    System.out.println("POR FAVOR INTENTE DE NUEVO");
                }
            } while (deNuevo3 == 1) ;

        }while(deNuevo ==1);
        direccion = calle + " "+ numero;
        Persona persona = new Persona(dni, nombre, direccion);
        return persona;

    }
}
