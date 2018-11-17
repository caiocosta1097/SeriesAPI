package com.example.caio.dcseries.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caio.dcseries.R;

public class AtorViewHolder extends RecyclerView.ViewHolder {

    ImageView foto;
    TextView txtNome, txtPersonagem;

    public AtorViewHolder(View view){
        super(view);

        foto = view.findViewById(R.id.foto);
        txtNome = view.findViewById(R.id.txtNome);
        txtPersonagem = view.findViewById(R.id.txtPersonagem);

    }

}
