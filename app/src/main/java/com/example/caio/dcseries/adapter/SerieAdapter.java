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

    public SerieAdapter(Context context){

        super(context, 0, new ArrayList<Serie>());

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null){

            view = LayoutInflater.from(getContext()).inflate(R.layout.list_view_item, parent, false);

        }

        Serie serie = getItem(position);

        TextView txtTitulo = view.findViewById(R.id.txtTitulo);
        ImageView poster = view.findViewById(R.id.poster);
        RatingBar ratingBar = view.findViewById(R.id.ratingbar);

        txtTitulo.setText(position + 1 + " - " + serie.getTitulo());
        Glide.with(getContext()).load(Constantes.BASE_IMAGES_URL + Constantes.IMAGES_SIZE + serie.getPoster()).into(poster);
        ratingBar.setRating(serie.getAvaliacao().floatValue() / 2);

        return  view;

    }
}
