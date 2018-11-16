package com.example.caio.dcseries;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.caio.dcseries.model.Serie;
import com.example.caio.dcseries.presenter.VisualizarPresenter;
import com.example.caio.dcseries.service.SerieService;
import com.example.caio.dcseries.service.ServiceFactory;
import com.example.caio.dcseries.util.DateUtil;
import com.example.caio.dcseries.view.VisualizarView;
import com.squareup.picasso.Picasso;

public class VisualizarActivity extends AppCompatActivity implements VisualizarView {

    VisualizarPresenter presenter;

    ProgressBar progressBar;

    CardView cardView;

    Toolbar toolbar;

    int id;

    ImageView fundo, imgAvalicao;
    TextView txtSinopse, txtTemporadas, txtEpisodios, txtAvalicao;
    TextView titulo1, titulo2, titulo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        id = getIntent().getIntExtra("idSerie", 0);
        toolbar = findViewById(R.id.toolbar);
        progressBar = findViewById(R.id.progressBar);
        cardView = findViewById(R.id.cardView);
        fundo = findViewById(R.id.fundo);
        imgAvalicao = findViewById(R.id.imgAvalicao);
        txtSinopse = findViewById(R.id.txtSinopse);
        txtTemporadas = findViewById(R.id.txtTemporadas);
        txtEpisodios = findViewById(R.id.txtEpisodios);
        txtAvalicao = findViewById(R.id.txtAvaliacao);
        titulo1 = findViewById(R.id.titulo1);
        titulo2 = findViewById(R.id.titulo2);
        titulo3 = findViewById(R.id.titulo3);

        presenter = new VisualizarPresenter(this, ServiceFactory.create());

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
        titulo1.setVisibility(View.GONE);
        titulo2.setVisibility(View.GONE);
        titulo3.setVisibility(View.GONE);

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
        titulo1.setVisibility(View.VISIBLE);
        titulo2.setVisibility(View.VISIBLE);
        titulo3.setVisibility(View.VISIBLE);

    }

    @Override
    public void pegarSerie(Serie serie) {

        toolbar.setTitle(serie.getTitulo());
        Picasso.get().load(SerieService.BASE_IMAGES_URL + SerieService.BACKDROP_SIZE + serie.getImagemFundo()).into(fundo);
        txtSinopse.setText(serie.getSinopse());
        txtTemporadas.setText(String.valueOf(serie.getnTemporadas()));
        txtEpisodios.setText(String.valueOf(serie.getnEpisodios()));
        txtAvalicao.setText(serie.getAvaliacao().toString() + "/10");

        if (serie.isStatus() == true)
            toolbar.setSubtitle("Ativa".toString());

         else
            toolbar.setSubtitle("Encerrada".toString());

    }
}
