package com.example.caio.dcseries.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AtoresResponse {
    //Classe com o response do ator

    //Nome do atributo que está na API e varíavel que recebe esse atributo
    @SerializedName("id")
    private int id;

    @SerializedName("cast")
    private List<Ator> cast;

    //MÉTODOS "GET" E "SET" DAS VARIÁVEIS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Ator> getCast() {
        return cast;
    }

    public void setCast(List<Ator> cast) {
        this.cast = cast;
    }
}
