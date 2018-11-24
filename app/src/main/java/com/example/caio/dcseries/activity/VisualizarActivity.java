package com.example.caio.dcseries.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
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

    // Inicializando as variáveis
    VisualizarPresenter presenter;
    ProgressBar progressBar;
    RecyclerView recyclerView;
    CardView cardView;
    Toolbar toolbar;
    int id;
    ImageView fundo, imgAvalicao;
    TextView txtSinopse, txtTemporadas, txtEpisodios, txtAvalicao, txtGenero, titulo1, titulo2, titulo3, titulo4, titulo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        // Remove a barra de status
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // Pega o id da série selecionada
        id = getIntent().getIntExtra("idSerie", 0);

        // Pega o id dos elementos do XML
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

        // Cria um presenter
        presenter = new VisualizarPresenter(this, ServiceFactory.create());

        // Carrega a série
        presenter.carregarSerie(id);

        // Carrega os atores da série
        presenter.carregarAtores(id);

    }

    // Método para exibir a barra de progresso
    @Override
    public void exibirBarraProgresso() {

        // progressBar é o único elemento visível na tela
        progressBar.setVisibility(View.VISIBLE);

        // Todos os outros desaparecem
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

    // Método para esconder a barra de progresso
    @Override
    public void esconderBarraProgresso() {

        // progressBar é o único elemento que desaparece
        progressBar.setVisibility(View.GONE);

        // Todos os outros ficam visíveis
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

    // Método para mostrar os atores da série
    @Override
    public void listaAtores(List<Ator> atores) {

        // Criando o recyclerView e já incluindo o adapter com os atores
        recyclerView.setAdapter(new AtorAdapter(atores, this));

        // Colocando a lista na horizontal
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        // Colocando a lista na horizontal no recyclerView
        recyclerView.setLayoutManager(layout);

    }

    // Método para pegar a série
    @Override
    public void pegarSerie(Serie serie) {

        // Array que recebe todos os gêneros da série
        Genero[] generos = serie.getGeneros();

        // Loop para incluir cada gênero do array no TextView usando o meétodo append
        for (int i = 0; i < generos.length; i++){

            // Verifica quais gêneros estão em inglês. Se estriver, coloca a tradução
            if (generos[i].getGenero().equals("Action & Adventure"))
                generos[i].setGenero("Ação & Aventura");

            else if (generos[i].getGenero().equals("Sci-Fi & Fantasy"))
                generos[i].setGenero("Ficção científica & Fantasia");

            else if (generos[i].getGenero().equals("War & Politics"))
                generos[i].setGenero("Guerra & Política");

            // Verificar se é o último item do array. Se for, não inclui um '\n', senão inclui um '\n'
            if (i == generos.length - 1)
                txtGenero.append(generos[i].getGenero());
            else
                txtGenero.append(generos[i].getGenero() + "\n");

        }

        // Preenchendo os elementos do XML com as informações da série
        toolbar.setTitle(serie.getTitulo());
        Picasso.get().load(Constantes.BASE_IMAGES_URL + Constantes.IMAGES_SIZE + serie.getImagemFundo()).into(fundo);
        txtSinopse.setText(serie.getSinopse());
        txtTemporadas.setText(String.valueOf(serie.getnTemporadas()));
        txtEpisodios.setText(String.valueOf(serie.getnEpisodios()));

        // Seperanda a avaliacao apatir do ponto e substituindo pela vírgula
        String[] avaliacao = String.valueOf(serie.getAvaliacao()).split("\\.");
        txtAvalicao.setText(avaliacao[0] + "," + avaliacao[1] + "/10");

        // Verificando se a série ainda está ativa. Se sim, estará 'Renovada', senão estará 'Finalizada'
        if (serie.isStatus() == true)
            toolbar.setSubtitle("Renovada");

         else
            toolbar.setSubtitle("Finalizada");

    }
}