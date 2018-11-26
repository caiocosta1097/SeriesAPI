package com.example.caio.dcseries.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caio.dcseries.R;

public class AtorViewHolder extends RecyclerView.ViewHolder {

    // Declara as variáveis utilizadas
    ImageView foto;
    TextView txtNome, txtPersonagem;

    // Construtor
    public AtorViewHolder(View view){
        super(view);

        // Pega o id dos elementos do XML
        //id da foto
        foto = view.findViewById(R.id.foto);
        //id do nome
        txtNome = view.findViewById(R.id.txtNome);
        //id do personagem
        txtPersonagem = view.findViewById(R.id.txtPersonagem);

    }

}
