package com.example.caio.dcseries.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.caio.dcseries.R;
import com.example.caio.dcseries.model.Ator;
import com.example.caio.dcseries.util.Constantes;

import java.util.List;

public class AtorAdapter extends RecyclerView.Adapter {

    // Variáveis do construtor
    private List<Ator> atores;
    private Context context;

    // Declarando o ViewHolder
    AtorViewHolder viewHolder;

    // Construtor
    public AtorAdapter(List<Ator> atores, Context context){

        this.atores = atores;
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Pegando o layout do XML
        View view = LayoutInflater.from(context).inflate(R.layout.list_view_atores, parent, false);

        // Criando um ViewHolder
        viewHolder = new AtorViewHolder(view);

        // Retorna o viewHolder
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        // viewHolder recebe o holder do método
        viewHolder = (AtorViewHolder) holder;

        // Cria um novo ator pegando a posição dele na lista
        Ator ator = atores.get(position);

        // Verifica se está sem foto. Se sim, põe uma imagem de indisponível
        if (ator.getFoto() == null)
            viewHolder.foto.setImageResource(R.drawable.indisponivel);
        //Senão põe a foto do ator
        else
            Glide.with(context).load(Constantes.BASE_IMAGES_URL + Constantes.IMAGES_SIZE + ator.getFoto()).into(viewHolder.foto);

        // Preenche as informações do com o nome
        viewHolder.txtNome.setText(ator.getNome());
        // Preenche as informações do com o personagem
        viewHolder.txtPersonagem.setText(ator.getPersonagem());

    }

    @Override
    public int getItemCount() {

        // Lista tem o tamanho do número de atores
        return atores.size();
    }
}
