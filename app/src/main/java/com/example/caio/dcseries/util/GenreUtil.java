package com.example.caio.dcseries.util;

import com.example.caio.dcseries.model.Genero;

public class GenreUtil {

    public static String[] PegarGeneros(Genero[] genero){

        String[] generos = new String[genero.length];

        for (int i = 0; i < genero.length; i++){

            generos[i] = genero[i].getGenero();

        }

        return generos;

    }

}
