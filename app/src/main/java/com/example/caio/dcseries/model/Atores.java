package com.example.caio.dcseries.model;

import com.google.gson.annotations.SerializedName;

public class Atores {

    @SerializedName("character")
    private String personagem;

    @SerializedName("name")
    private String nome;

    @SerializedName("profile_path")
    private String foto;

    public String getPersonagem() {
        return personagem;
    }

    public void setPersonagem(String personagem) {
        this.personagem = personagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}