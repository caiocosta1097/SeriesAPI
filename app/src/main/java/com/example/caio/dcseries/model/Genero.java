package com.example.caio.dcseries.model;

import com.google.gson.annotations.SerializedName;

public class Genero {
    //Classe de modelagem do gênero

    //Nome do atributo que está na API e varíavel que recebe esse atributo
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String genero;

    //MÉTODOS "GET" E "SET" DAS VARIÁVEIS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
