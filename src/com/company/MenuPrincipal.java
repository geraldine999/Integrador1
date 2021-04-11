package com.company;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MenuPrincipal {

    public int preguntarNumeroSeccionalElegida(List<RegistroSeccional> registrosSeccionales){
        Scanner sc = new Scanner(System.in);
        int salirDeDoWhile = 0;
        int numeroSeccionalElegida = 0;
        do {
            //muestra las seccionales
            for (int i = 0; i < registrosSeccionales.size(); i ++){
                System.out.println(i + "= "+ registrosSeccionales.get(i).getNombre());
            }
            System.out.print("INGRESE EL NÚMERO DE SU SECCIONAL: ");

            //valida el numero de seccional elegido
            try {
                numeroSeccionalElegida = Integer.parseInt(sc.nextLine());
                if (numeroSeccionalElegida >= registrosSeccionales.size() || numeroSeccionalElegida < 0) {
                    System.out.println("NÚMERO INVÁLIDO, INTENTE DE NUEVO");
                } else {
                    salirDeDoWhile = 1;
                }
            }catch(NumberFormatException e){
                System.out.println("CARACTER INVALIDO, INTENTE DE NUEVO");
            }
        }while(salirDeDoWhile == 0);

        System.out.print("USTED ELIGIÓ LA SECCIONAL ");
        for( RegistroSeccional seccional : registrosSeccionales){
            if( numeroSeccionalElegida == registrosSeccionales.indexOf(seccional)){
                System.out.println(seccional.getNombre().toUpperCase(Locale.ROOT));
                System.out.println();
            }
        }
        return numeroSeccionalElegida;

    }
}
