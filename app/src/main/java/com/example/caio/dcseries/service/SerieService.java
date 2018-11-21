package com.example.caio.dcseries.service;

import com.example.caio.dcseries.model.AtoresResponse;
import com.example.caio.dcseries.model.Serie;
import com.example.caio.dcseries.model.SeriesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SerieService {

    @GET("/3/tv/popular")
    Call<SeriesResponse> obterSeriesPopulares(@Query("api_key") String API_KEY, @Query("language") String lang, @Query("page") int page);

    @GET("3/tv/{tv_id}")
    Call<Serie> obterSerie(@Path("tv_id") int id, @Query("api_key") String API_KEY, @Query("language") String lang);

    @GET("3/tv/{tv_id}/credits")
    Call<AtoresResponse> obterAtor(@Path("tv_id") int id, @Query("api_key") String API_KEY, @Query("language") String lang);

}
