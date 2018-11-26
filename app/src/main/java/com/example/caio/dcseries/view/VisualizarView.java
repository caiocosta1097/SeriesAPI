package com.example.caio.dcseries.view;

import com.example.caio.dcseries.model.Ator;
import com.example.caio.dcseries.model.Serie;

import java.util.List;

public interface VisualizarView {

    //Método chamado para exibir o progresso
    void exibirBarraProgresso();

    //Método chamado para esconder o progresso
    void esconderBarraProgresso();

    //Método chamado para visualizar a série escolhida
    void pegarSerie(Serie serie);

    //Método chamado para exibir a lista com os atores
    void listaAtores(List<Ator> atores);

}
