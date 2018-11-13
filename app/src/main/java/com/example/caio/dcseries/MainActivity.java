package com.example.caio.dcseries;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.caio.dcseries.adapter.SerieAdapter;
import com.example.caio.dcseries.model.Serie;
import com.example.caio.dcseries.presenter.MainPresenter;
import com.example.caio.dcseries.service.ServiceFactory;
import com.example.caio.dcseries.view.MainView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    ListView listView;
    SerieAdapter adapter;

    ProgressBar progressBar;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        listView = findViewById(R.id.listView);

        adapter = new SerieAdapter(this);

        listView.setAdapter(adapter);

        presenter = new MainPresenter(this, ServiceFactory.create());

    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.carregarSeries();

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

        adapter.clear();
        adapter.addAll(listSeries);

    }
}
