package com.example.caio.dcseries.model;

import com.google.gson.annotations.SerializedName;

public class Genero {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String genero;

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
