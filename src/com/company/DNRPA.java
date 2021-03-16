package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DNRPA {

    public static void main(String[] args) {
        //ASIGNAR PATENTES RANDOM
        //TERMINAR registrarAutomotor
        //CARGAR ALGUNOS AUTOMMOTORES
        //TODO agregar nombres clases (static final)
        //TODO corregir tipo de automotor in listarAutomotores in RegistroSeccional
        //TODO agregar ENUMS para tipos de usos

        //LA LISTA DE SECCIONALES ES FIJA
        //Porque no puedo crear seccionales de un dia para el otro
        //Creo una lista de registros seccionales
        List<RegistroSeccional> registrosSeccionales = new ArrayList<>();

        //Agrego 2 registros seccionales
        registrosSeccionales.add(new RegistroSeccional("Tigre"));
        registrosSeccionales.add(new RegistroSeccional("Belgrano"));

        //MENU
        MenuPrincipal menu = new MenuPrincipal();

        int numeroSeccionalElegida = menu.preguntarNumeroSeccionalElegida(registrosSeccionales);

        registrosSeccionales.get(numeroSeccionalElegida).mostrarMenu();














    }
}
