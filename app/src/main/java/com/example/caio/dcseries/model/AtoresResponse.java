package com.example.caio.dcseries.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AtoresResponse {

    @SerializedName("id")
    private int id;

    @SerializedName("cast")
    private List<Ator> cast;

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
