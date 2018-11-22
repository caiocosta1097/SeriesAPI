package com.example.caio.dcseries.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.caio.dcseries.R;
import com.example.caio.dcseries.adapter.SerieAdapter;
import com.example.caio.dcseries.model.Serie;
import com.example.caio.dcseries.presenter.MainPresenter;
import com.example.caio.dcseries.service.ServiceFactory;
import com.example.caio.dcseries.view.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemClickListener {

    // Inicializando as variáveis
    ListView listView;
    SerieAdapter adapter;
    ProgressBar progressBar;
    MainPresenter presenter;
    int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Pega o id dos elementos do XML
        progressBar = findViewById(R.id.progressBar);
        listView = findViewById(R.id.listView);

        // Criando o adapter
        adapter = new SerieAdapter(this);

        // Coloca o adapter no listView
        listView.setAdapter(adapter);

        // Evento de click do listView
        listView.setOnItemClickListener(this);

        // Criando o presenter
        presenter = new MainPresenter(this, ServiceFactory.create());

        // Carrega as séries no presenter com o número da página
        presenter.carregarSeries(page);

        // Evento de rolagem do listView
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

                // Verifica se é o último item do listView
                if (listView.getLastVisiblePosition() >= listView.getCount() - 1) {

                    // Verifica se as páginas são menores que 1000. Se for, vai para próxima página
                    if (page < 1000){

                        page++;
                        presenter.carregarSeries(page);

                    }
                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }

    // Método para exibir a barra de progresso
    @Override
    public void exibirBarraProgresso() {

        // progressBar é o único elemento visível na tela
        progressBar.setVisibility(View.VISIBLE);

        // listView desaparece
        listView.setVisibility(View.GONE);

    }

    // Método para esconder a barra de progresso
    @Override
    public void esconderBarraProgresso() {

        // progressBar é o único elemento que desaparece
        progressBar.setVisibility(View.GONE);

        // listView fica visível
        listView.setVisibility(View.VISIBLE);

    }

    // Método para mostrar as séries
    @Override
    public void listaSeries(List<Serie> listSeries) {

        // Coloca todas as séries no adapter
        adapter.addAll(listSeries);

    }

    // Método de click do listView
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        // Pega a posição da série selecionada
        Serie serie = adapter.getItem(position);

        // Cria um intent que recebe a activity de visualizar
        Intent intent = new Intent(this, VisualizarActivity.class);

        // Pega o id da série selecionada e coloca no intent
        intent.putExtra("idSerie", serie.getId());

        // Chama a activity
        startActivity(intent);

    }
}
