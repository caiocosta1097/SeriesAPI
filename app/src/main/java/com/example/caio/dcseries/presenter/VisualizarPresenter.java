package com.example.caio.dcseries.presenter;

import com.example.caio.dcseries.model.Serie;
import com.example.caio.dcseries.service.SerieService;
import com.example.caio.dcseries.view.VisualizarView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisualizarPresenter {

    VisualizarView view;
    SerieService service;

    public VisualizarPresenter(VisualizarView view, SerieService service){

        this.view = view;
        this.service = service;

    }

    public void carregarSerie(int id){

        Call<Serie> call = service.obterSerie(id, SerieService.API_KEY, "pt-BR");

        view.exibirBarraProgresso();

        call.enqueue(new Callback<Serie>() {
            @Override
            public void onResponse(Call<Serie> call, Response<Serie> response) {

                Serie serie = response.body();

                view.pegarSerie(serie);

                view.esconderBarraProgresso();

            }

            @Override
            public void onFailure(Call<Serie> call, Throwable t) {

            }
        });

    }

}