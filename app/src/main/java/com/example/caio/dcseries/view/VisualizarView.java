package com.example.caio.dcseries.view;

import com.example.caio.dcseries.model.Serie;

public interface VisualizarView {

    void exibirBarraProgresso();

    void esconderBarraProgresso();

    void pegarSerie(Serie serie);

}
