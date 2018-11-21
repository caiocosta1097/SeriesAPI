package com.example.caio.dcseries.presenter;

import android.util.Log;

import com.example.caio.dcseries.model.SeriesResponse;

import com.example.caio.dcseries.model.Serie;
import com.example.caio.dcseries.service.SerieService;
import com.example.caio.dcseries.util.Constantes;
import com.example.caio.dcseries.view.MainView;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    MainView view;
    SerieService service;

    public MainPresenter(MainView view, SerieService service){

        this.view = view;
        this.service = service;

    }

    public void carregarSeries(int page){

        Call<SeriesResponse> call = service.obterSeriesPopulares(Constantes.API_KEY, "pt-BR", page);

        view.exibirBarraProgresso();

        call.enqueue(new Callback<SeriesResponse>() {
            @Override
            public void onResponse(Call<SeriesResponse> call, Response<SeriesResponse> response) {

                List<Serie> series = response.body().getResults();

                view.listaSeries(series);

                view.esconderBarraProgresso();

            }

            @Override
            public void onFailure(Call<SeriesResponse> call, Throwable t) {

                Log.e("ERRO_API", t.getMessage());

            }
        });

    }

}
