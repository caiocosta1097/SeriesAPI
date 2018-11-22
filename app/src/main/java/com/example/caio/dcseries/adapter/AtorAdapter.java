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

    private List<Ator> atores;
    private Context context;

    public AtorAdapter(List<Ator> atores, Context context){

        this.atores = atores;
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_view_atores, parent, false);

        AtorViewHolder viewHolder = new AtorViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        AtorViewHolder viewHolder = (AtorViewHolder) holder;

        Ator ator = atores.get(position);

        if (ator.getFoto() == null)
            viewHolder.foto.setImageResource(R.drawable.indisponivel);

        else
            Glide.with(context).load(Constantes.BASE_IMAGES_URL + Constantes.IMAGES_SIZE + ator.getFoto()).into(viewHolder.foto);

        viewHolder.txtNome.setText(ator.getNome());
        viewHolder.txtPersonagem.setText(ator.getPersonagem());

    }

    @Override
    public int getItemCount() {
        return atores.size();
    }
}
