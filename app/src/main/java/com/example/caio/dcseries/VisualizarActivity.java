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
import com.example.caio.dcseries.view.VisualizarView;
import com.squareup.picasso.Picasso;

public class VisualizarActivity extends AppCompatActivity implements VisualizarView {

    VisualizarPresenter presenter;

    int id;

    ProgressBar progressBar;

    ImageView fundo;
    TextView txtTitulo, txtTituloOrignal, txtEstreia, txtSinopse;

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
        txtEstreia.setVisibility(View.GONE);
        txtSinopse.setVisibility(View.GONE);


    }

    @Override
    public void esconderBarraProgresso() {

        progressBar.setVisibility(View.GONE);
        fundo.setVisibility(View.VISIBLE);
        txtTitulo.setVisibility(View.VISIBLE);
        txtTituloOrignal.setVisibility(View.VISIBLE);
        txtEstreia.setVisibility(View.VISIBLE);
        txtSinopse.setVisibility(View.VISIBLE);

    }

    @Override
    public void pegarSerie(Serie serie) {

        Picasso.get().load(SerieService.BASE_IMAGES_URL + SerieService.BACKDROP_SIZE + serie.getImagemFundo()).into(fundo);
        txtTitulo.setText("Título: " + serie.getTitulo());
        txtTituloOrignal.setText("Título original: " + serie.getTituloOrignal());
        txtEstreia.setText("Estreia: " + serie.getEstreia());
        txtSinopse.setText("Sinopse: " + serie.getSinopse());

    }
}
