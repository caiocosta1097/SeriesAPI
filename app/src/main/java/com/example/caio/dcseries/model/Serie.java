package com.example.caio.dcseries.model;

import com.google.gson.annotations.SerializedName;

public class Serie {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String titulo;

    @SerializedName("original_name")
    private String tituloOrignal;

    @SerializedName("poster_path")
    private String poster;

    @SerializedName("backdrop_path")
    private String imagemFundo;

    @SerializedName("overview")
    private String sinopse;

    @SerializedName("popularity")
    private Number popularidade;

    @SerializedName("first_air_date")
    private String estreia;

    @SerializedName("vote_average")
    private Number avaliacao;

    @SerializedName("number_of_episodes")
    private int nEpisodios;

    @SerializedName("number_of_seasons")
    private int nTemporadas;

    @SerializedName("in_production")
    private boolean status;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTituloOrignal() {
        return tituloOrignal;
    }

    public void setTituloOrignal(String tituloOrignal) {
        this.tituloOrignal = tituloOrignal;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getImagemFundo() {
        return imagemFundo;
    }

    public void setImagemFundo(String imagemFundo) {
        this.imagemFundo = imagemFundo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Number getPopularidade() {
        return popularidade;
    }

    public void setPopularidade(Number popularidade) {
        this.popularidade = popularidade;
    }

    public String getEstreia() {
        return estreia;
    }

    public void setEstreia(String estreia) {
        this.estreia = estreia;
    }

    public Number getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Number avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getnEpisodios() {
        return nEpisodios;
    }

    public void setnEpisodios(int nEpisodios) {
        this.nEpisodios = nEpisodios;
    }

    public int getnTemporadas() {
        return nTemporadas;
    }

    public void setnTemporadas(int nTemporadas) {
        this.nTemporadas = nTemporadas;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
