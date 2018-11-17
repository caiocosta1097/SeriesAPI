package com.example.caio.dcseries.view;

import com.example.caio.dcseries.model.Atores;
import com.example.caio.dcseries.model.Serie;

import java.util.List;

public interface VisualizarView {

    void exibirBarraProgresso();

    void esconderBarraProgresso();

    void pegarSerie(Serie serie);

    void listaAtores(List<Atores> atores);

}
