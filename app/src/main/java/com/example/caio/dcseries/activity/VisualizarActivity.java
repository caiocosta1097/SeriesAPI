package com.example.caio.dcseries.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.caio.dcseries.R;
import com.example.caio.dcseries.adapter.AtorAdapter;
import com.example.caio.dcseries.model.Ator;
import com.example.caio.dcseries.model.Genero;
import com.example.caio.dcseries.model.Serie;
import com.example.caio.dcseries.presenter.VisualizarPresenter;
import com.example.caio.dcseries.service.ServiceFactory;
import com.example.caio.dcseries.util.Constantes;
import com.example.caio.dcseries.view.VisualizarView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VisualizarActivity extends AppCompatActivity implements VisualizarView {

    VisualizarPresenter presenter;

    ProgressBar progressBar;

    RecyclerView recyclerView;

    CardView cardView;

    Toolbar toolbar;

    int id;

    ImageView fundo, imgAvalicao;
    TextView txtSinopse, txtTemporadas, txtEpisodios, txtAvalicao, txtGenero;
    TextView titulo1, titulo2, titulo3, titulo4, titulo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        id = getIntent().getIntExtra("idSerie", 0);

        toolbar = findViewById(R.id.toolbar);
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        cardView = findViewById(R.id.cardView);
        fundo = findViewById(R.id.fundo);
        imgAvalicao = findViewById(R.id.imgAvalicao);
        txtSinopse = findViewById(R.id.txtSinopse);
        txtTemporadas = findViewById(R.id.txtTemporadas);
        txtEpisodios = findViewById(R.id.txtEpisodios);
        txtAvalicao = findViewById(R.id.txtAvaliacao);
        txtGenero = findViewById(R.id.txtGenero);
        titulo1 = findViewById(R.id.titulo1);
        titulo2 = findViewById(R.id.titulo2);
        titulo3 = findViewById(R.id.titulo3);
        titulo4 = findViewById(R.id.titulo4);
        titulo5 = findViewById(R.id.titulo5);

        presenter = new VisualizarPresenter(this, ServiceFactory.create());

        presenter.carregarAtores(id);

    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.carregarSerie(id);

    }

    @Override
    public void exibirBarraProgresso() {

        progressBar.setVisibility(View.VISIBLE);
        toolbar.setVisibility(View.GONE);
        cardView.setVisibility(View.GONE);
        fundo.setVisibility(View.GONE);
        imgAvalicao.setVisibility(View.GONE);
        txtTemporadas.setVisibility(View.GONE);
        txtEpisodios.setVisibility(View.GONE);
        txtAvalicao.setVisibility(View.GONE);
        txtSinopse.setVisibility(View.GONE);
        txtGenero.setVisibility(View.GONE);
        titulo1.setVisibility(View.GONE);
        titulo2.setVisibility(View.GONE);
        titulo3.setVisibility(View.GONE);
        titulo4.setVisibility(View.GONE);
        titulo5.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);

    }

    @Override
    public void esconderBarraProgresso() {

        progressBar.setVisibility(View.GONE);
        toolbar.setVisibility(View.VISIBLE);
        cardView.setVisibility(View.VISIBLE);
        fundo.setVisibility(View.VISIBLE);
        imgAvalicao.setVisibility(View.VISIBLE);
        txtTemporadas.setVisibility(View.VISIBLE);
        txtEpisodios.setVisibility(View.VISIBLE);
        txtAvalicao.setVisibility(View.VISIBLE);
        txtSinopse.setVisibility(View.VISIBLE);
        txtGenero.setVisibility(View.VISIBLE);
        titulo1.setVisibility(View.VISIBLE);
        titulo2.setVisibility(View.VISIBLE);
        titulo3.setVisibility(View.VISIBLE);
        titulo4.setVisibility(View.VISIBLE);
        titulo5.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.VISIBLE);

    }

    @Override
    public void listaAtores(List<Ator> atores) {

        recyclerView.setAdapter(new AtorAdapter(atores, this));

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layout);

    }

    @Override
    public void pegarSerie(Serie serie) {

        Genero[] generos = serie.getGeneros();

        for (int i = 0; i < generos.length; i++){

            if (i == generos.length - 1)
                txtGenero.append(generos[i].getGenero());
            else
                txtGenero.append(generos[i].getGenero() + "\n");

        }

        toolbar.setTitle(serie.getTitulo());
        Picasso.get().load(Constantes.BASE_IMAGES_URL + Constantes.IMAGES_SIZE + serie.getImagemFundo()).into(fundo);
        txtSinopse.setText(serie.getSinopse());
        txtTemporadas.setText(String.valueOf(serie.getnTemporadas()));
        txtEpisodios.setText(String.valueOf(serie.getnEpisodios()));
        txtAvalicao.setText(serie.getAvaliacao().toString() + "/10");

        if (serie.isStatus() == true)
            toolbar.setSubtitle("Renovada");

         else
            toolbar.setSubtitle("Finalizada");

    }
}
