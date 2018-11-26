package com.example.caio.dcseries.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.caio.dcseries.R;
import com.example.caio.dcseries.model.Serie;
import com.example.caio.dcseries.util.Constantes;

import java.util.ArrayList;

public class SerieAdapter extends ArrayAdapter<Serie> {

    // Construtor
    public SerieAdapter(Context context){

        super(context, 0, new ArrayList<Serie>());

    }
    //Adapter da série
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // view recebe o convertView
        View view = convertView;

        // Vefifica se a view está null. Se sim, colocao layout da séries
        if (view == null){

            view = LayoutInflater.from(getContext()).inflate(R.layout.list_view_item, parent, false);

        }

        // Cria uma nova série pegando a posição da lista
        Serie serie = getItem(position);

        // Pega o id dos elementos XML
        //id do titulo
        TextView txtTitulo = view.findViewById(R.id.txtTitulo);
        //id do poster
        ImageView poster = view.findViewById(R.id.poster);
        //id do ratingBar
        RatingBar ratingBar = view.findViewById(R.id.ratingbar);

        // Preenche as informações da série
        txtTitulo.setText(position + 1 + " - " + serie.getTitulo());
        Glide.with(getContext()).load(Constantes.BASE_IMAGES_URL + Constantes.IMAGES_SIZE + serie.getPoster()).into(poster);
        ratingBar.setRating(serie.getAvaliacao().floatValue() / 2);

        // Retorna a view
        return  view;

    }
}
