package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DNRPA {

    public static void main(String[] args) {
        //todo CARGAR ALGUNOS AUTOMMOTORES
        //TODO corregir Strings tipo de automotor y tipo de uso in listarAutomotores in RegistroSeccional
        //todo sacar los nextInt y poner parseInt
        //todo agregar lineas y mensajes en  mayuscula
        //todo cuando  agregas enums si pones una opcion que no va no te dice nada

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
