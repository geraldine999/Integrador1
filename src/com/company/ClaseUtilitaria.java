package com.company;

import java.util.Locale;
import java.util.Random;

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
}
