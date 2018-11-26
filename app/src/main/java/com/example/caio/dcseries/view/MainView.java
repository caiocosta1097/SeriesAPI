package com.example.caio.dcseries.view;

import com.example.caio.dcseries.model.Serie;

import java.util.List;

public interface MainView {

    //Método chamado para exibir o progresso
    void exibirBarraProgresso();

    //Método chamado para esconder o progresso
    void esconderBarraProgresso();

    //Método chamado para exibir a lista com as séries
    void listaSeries(List<Serie> listSeries);

}
