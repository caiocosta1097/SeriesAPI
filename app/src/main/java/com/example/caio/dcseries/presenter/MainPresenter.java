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
    // Inicializando as variáveis
    MainView view;
    SerieService service;

    //Construtor do Main Presenter
    public MainPresenter(MainView view, SerieService service){

        this.view = view;
        this.service = service;

    }
    //Método para carregar as séries
    public void carregarSeries(int page){

        //Call que recebe da URL com a chave de segurança, a linguagem e a página
        Call<SeriesResponse> call = service.obterSeriesPopulares(Constantes.API_KEY, "pt-BR", page);

        //Exibindo a barra de progresso
        view.exibirBarraProgresso();

        call.enqueue(new Callback<SeriesResponse>() {
            @Override
            public void onResponse(Call<SeriesResponse> call, Response<SeriesResponse> response) {

                //Recebe as séries em uma lista
                List<Serie> series = response.body().getResults();

                //Exibe as séries
                view.listaSeries(series);

                //Esconde a barra de progresso
                view.esconderBarraProgresso();

            }
            //Mensagem de erro caso não carregue as séries
            @Override
            public void onFailure(Call<SeriesResponse> call, Throwable t) {

                Log.e("ERRO_API", t.getMessage());

            }
        });

    }

}
