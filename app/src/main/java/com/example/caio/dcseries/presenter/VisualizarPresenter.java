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
    // Inicializando as variáveis
    VisualizarView view;
    SerieService service;

    //Construtor do Visualizar Presenter
    public VisualizarPresenter(VisualizarView view, SerieService service){

        this.view = view;
        this.service = service;

    }
    //Método para carregar apenas a série a ser visualizada
    public void carregarSerie(int id){

        //Call que recebe o id, chave de segurança da API e a linguagem
        Call<Serie> call = service.obterSerie(id, Constantes.API_KEY, "pt-BR");

        //Exibe a barra de progresso
        view.exibirBarraProgresso();

        call.enqueue(new Callback<Serie>() {
            @Override
            public void onResponse(Call<Serie> call, Response<Serie> response) {

                //Recebe a série que será visualizada
                Serie serie = response.body();

                //Exibe a série escolhida
                view.pegarSerie(serie);

                //Esconde a barra de progresso
                view.esconderBarraProgresso();

            }
            //Mensagem de erro caso não carregue dê erro ao visualizar a série
            @Override
            public void onFailure(Call<Serie> call, Throwable t) {

            }
        });

    }
    //Método para carregar os atores da série escolhida
    public void carregarAtores(int id){

        //Call que recebe o id, chave de segurança da API e a linguagem
        Call<AtoresResponse> call = service.obterAtor(id, Constantes.API_KEY, "pt-BR");

        call.enqueue(new Callback<AtoresResponse>() {
            @Override
            public void onResponse(Call<AtoresResponse> call, Response<AtoresResponse> response) {
                //Recebe os atores em uma lista
               List<Ator> atores = response.body().getCast();

               //Exibe a lista de atores
               view.listaAtores(atores);

            }
            //Mensagem de erro caso não carregue dê erro ao visualizar a série
            @Override
            public void onFailure(Call<AtoresResponse> call, Throwable t) {

            }
        });

    }

}
