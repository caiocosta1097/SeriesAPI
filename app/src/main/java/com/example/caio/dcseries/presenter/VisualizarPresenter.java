package com.example.caio.dcseries.presenter;

import com.example.caio.dcseries.model.Ator;
import com.example.caio.dcseries.model.AtoresResponse;
import com.example.caio.dcseries.model.Serie;
import com.example.caio.dcseries.service.SerieService;
import com.example.caio.dcseries.util.Constantes;
import com.example.caio.dcseries.view.VisualizarView;

import java.util.List;

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

        Call<Serie> call = service.obterSerie(id, Constantes.API_KEY, "pt-BR");

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

    public void carregarAtores(int id){

        Call<AtoresResponse> call = service.obterAtor(id, Constantes.API_KEY, "pt-BR");

        call.enqueue(new Callback<AtoresResponse>() {
            @Override
            public void onResponse(Call<AtoresResponse> call, Response<AtoresResponse> response) {

               List<Ator> atores = response.body().getCast();

               view.listaAtores(atores);

            }

            @Override
            public void onFailure(Call<AtoresResponse> call, Throwable t) {

            }
        });

    }

}
