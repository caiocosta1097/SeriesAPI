package com.example.caio.dcseries.util;

public class DateUtil {

    public String formatarData(String data){

        String[] dataSplit = data.split("-");

        String dia = dataSplit[2];
        String mes = dataSplit[1];
        String ano = dataSplit[0];

        String dataFormatada = dia + "/" + mes + "/" + ano;

        return dataFormatada;

    }

}
