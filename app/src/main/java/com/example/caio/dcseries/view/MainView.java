package com.example.caio.dcseries.view;

import com.example.caio.dcseries.model.Serie;

import java.util.List;

public interface MainView {

    void exibirBarraProgresso();

    void esconderBarraProgresso();

    void listaSeries(List<Serie> listSeries);

}
