package com.example.caio.dcseries.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.caio.dcseries.R;
import com.example.caio.dcseries.model.Atores;
import com.example.caio.dcseries.service.SerieService;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AtorAdapter extends RecyclerView.Adapter {

    private List<Atores> atores;
    private Context context;

    public AtorAdapter(List<Atores> atores, Context context){

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

        Atores ator = atores.get(position);

        Picasso.get().load(SerieService.BASE_IMAGES_URL + SerieService.POSTER_SIZE + ator.getFoto()).into(((AtorViewHolder) holder).foto);

        ((AtorViewHolder) holder).txtNome.setText(ator.getNome());
        ((AtorViewHolder) holder).txtPersonagem.setText(ator.getPersonagem());

    }

    @Override
    public int getItemCount() {
        return atores.size();
    }
}
