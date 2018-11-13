package com.example.caio.dcseries.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {

    public static SerieService create(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SerieService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(SerieService.class);

    }

}
