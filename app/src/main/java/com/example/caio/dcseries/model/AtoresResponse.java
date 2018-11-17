package com.example.caio.dcseries.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AtoresResponse {

    @SerializedName("id")
    private int id;

    @SerializedName("cast")
    private List<Atores> cast;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Atores> getCast() {
        return cast;
    }

    public void setCast(List<Atores> cast) {
        this.cast = cast;
    }
}
