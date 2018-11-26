package com.example.caio.dcseries.service;

import com.example.caio.dcseries.model.AtoresResponse;
import com.example.caio.dcseries.model.Serie;
import com.example.caio.dcseries.model.SeriesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SerieService {

    //Chamada para API para pegar todas as séries mais populares
    @GET("/3/tv/popular")
    Call<SeriesResponse> obterSeriesPopulares(@Query("api_key") String API_KEY, @Query("language") String lang, @Query("page") int page);

    //Chamada para API para pegar apenas a série escolhida para ser visualizada
    @GET("3/tv/{tv_id}")
    Call<Serie> obterSerie(@Path("tv_id") int id, @Query("api_key") String API_KEY, @Query("language") String lang);

    //Chamada para API para obter os atores da série ao visualizar apenas a série desejada
    @GET("3/tv/{tv_id}/credits")
    Call<AtoresResponse> obterAtor(@Path("tv_id") int id, @Query("api_key") String API_KEY, @Query("language") String lang);

}
