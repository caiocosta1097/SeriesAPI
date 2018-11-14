package com.example.caio.dcseries;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

    int id;

    ImageView fundo;
    TextView txtTitulo, txtTituloOrignal, txtEstreia, txtSinopse, txtTemporadas, txtEpisodios, txtStatus;
    TextView titulo1, titulo2, titulo3, titulo4, titulo5, titulo6, titulo7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        id = getIntent().getIntExtra("idSerie", 0);

        progressBar = findViewById(R.id.progressBar);
        fundo = findViewById(R.id.fundo);
        txtTitulo = findViewById(R.id.txtTitulo);
        txtTituloOrignal = findViewById(R.id.txtTituloOriginal);
        txtEstreia = findViewById(R.id.txtEstreia);
        txtSinopse = findViewById(R.id.txtSinopse);
        txtTemporadas = findViewById(R.id.txtTemporadas);
        txtEpisodios = findViewById(R.id.txtEpisodios);
        txtStatus = findViewById(R.id.txtStatus);
        titulo1 = findViewById(R.id.titulo1);
        titulo2 = findViewById(R.id.titulo2);
        titulo3 = findViewById(R.id.titulo3);
        titulo4 = findViewById(R.id.titulo4);
        titulo5 = findViewById(R.id.titulo5);
        titulo6 = findViewById(R.id.titulo6);
        titulo7 = findViewById(R.id.titulo7);

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
        fundo.setVisibility(View.GONE);
        txtTitulo.setVisibility(View.GONE);
        txtTituloOrignal.setVisibility(View.GONE);
        txtTemporadas.setVisibility(View.GONE);
        txtEpisodios.setVisibility(View.GONE);
        txtStatus.setVisibility(View.GONE);
        txtEstreia.setVisibility(View.GONE);
        txtSinopse.setVisibility(View.GONE);
        titulo1.setVisibility(View.GONE);
        titulo2.setVisibility(View.GONE);
        titulo3.setVisibility(View.GONE);
        titulo4.setVisibility(View.GONE);
        titulo5.setVisibility(View.GONE);
        titulo6.setVisibility(View.GONE);
        titulo7.setVisibility(View.GONE);

    }

    @Override
    public void esconderBarraProgresso() {

        progressBar.setVisibility(View.GONE);
        fundo.setVisibility(View.VISIBLE);
        txtTitulo.setVisibility(View.VISIBLE);
        txtTituloOrignal.setVisibility(View.VISIBLE);
        txtTemporadas.setVisibility(View.VISIBLE);
        txtEpisodios.setVisibility(View.VISIBLE);
        txtStatus.setVisibility(View.VISIBLE);
        txtEstreia.setVisibility(View.VISIBLE);
        txtSinopse.setVisibility(View.VISIBLE);
        titulo1.setVisibility(View.VISIBLE);
        titulo2.setVisibility(View.VISIBLE);
        titulo3.setVisibility(View.VISIBLE);
        titulo4.setVisibility(View.VISIBLE);
        titulo5.setVisibility(View.VISIBLE);
        titulo6.setVisibility(View.VISIBLE);
        titulo7.setVisibility(View.VISIBLE);

    }

    @Override
    public void pegarSerie(Serie serie) {

        String estreia = new DateUtil().formatarData(serie.getEstreia());

        Picasso.get().load(SerieService.BASE_IMAGES_URL + SerieService.BACKDROP_SIZE + serie.getImagemFundo()).into(fundo);
        txtTitulo.setText(serie.getTitulo());
        txtTituloOrignal.setText(serie.getTituloOrignal());
        txtEstreia.setText(estreia);
        txtSinopse.setText(serie.getSinopse());
        txtTemporadas.setText(String.valueOf(serie.getnTemporadas()));
        txtEpisodios.setText(String.valueOf(serie.getnEpisodios()));

        if (serie.isStatus() == true)
            txtStatus.setText("Ativa");

        else
            txtStatus.setText("Encerrada");


    }
}
