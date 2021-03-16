package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MenuPrincipal {

    public int preguntarNumeroSeccionalElegida(List<RegistroSeccional> registrosSeccionales){
        Scanner sc = new Scanner(System.in);
        System.out.println("BIENVENIDO");
        int salirDeDoWhile = 0;
        int numeroSeccionalElegida = 0;
        do {
            //muestra las seccionales
            for (int i = 0; i < registrosSeccionales.size(); i ++){
                System.out.println(i + "= "+ registrosSeccionales.get(i).getNombre());
            }
            System.out.print("Ingrese el numero de su seccional: ");
            numeroSeccionalElegida = sc.nextInt();
            //valida el numero de seccional elegido
            if(numeroSeccionalElegida >= registrosSeccionales.size() || numeroSeccionalElegida< 0){
                System.out.println("Numero invalido, intente de nuevo");
            }else{
                salirDeDoWhile = 1;
            }
        }while(salirDeDoWhile == 0);

        System.out.print("USTED ELIGIO LA SECCIONAL ");
        for( RegistroSeccional seccional : registrosSeccionales){
            if( numeroSeccionalElegida == registrosSeccionales.indexOf(seccional)){
                System.out.print(seccional.getNombre().toUpperCase(Locale.ROOT));
                System.out.println();
            }
        }
        return numeroSeccionalElegida;

    }
}
