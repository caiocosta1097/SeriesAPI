package com.example.caio.dcseries.model;

import com.google.gson.annotations.SerializedName;

public class Ator {

    //Nome do atributo que está na API e varíavel que recebe esse atributo
    @SerializedName("character")
    private String personagem;

    @SerializedName("name")
    private String nome;

    @SerializedName("profile_path")
    private String foto;

    //MÉTODOS "GET" E "SET" DAS VARIÁVEIS
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
