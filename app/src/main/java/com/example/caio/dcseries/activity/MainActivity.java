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

    ListView listView;

    SerieAdapter adapter;

    ProgressBar progressBar;

    MainPresenter presenter;

    int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        listView = findViewById(R.id.listView);

        adapter = new SerieAdapter(this);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        presenter = new MainPresenter(this, ServiceFactory.create());

        presenter.carregarSeries(page);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

                if (scrollState == SCROLL_STATE_IDLE) {
                    if (listView.getLastVisiblePosition() >= listView.getCount() - 1) {

                        if (page != 1000){

                            page++;
                            presenter.carregarSeries(page);

                        }
                    }
                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }

    @Override
    public void exibirBarraProgresso() {

        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.GONE);

    }

    @Override
    public void esconderBarraProgresso() {

        progressBar.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);

    }

    @Override
    public void listaSeries(List<Serie> listSeries) {

        adapter.addAll(listSeries);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Serie serie = adapter.getItem(position);

        Intent intent = new Intent(this, VisualizarActivity.class);

        intent.putExtra("idSerie", serie.getId());

        startActivity(intent);

    }
}
