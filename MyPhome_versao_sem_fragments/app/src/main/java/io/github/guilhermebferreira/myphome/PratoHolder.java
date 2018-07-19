package io.github.guilhermebferreira.myphome;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class PratoHolder extends RecyclerView.ViewHolder {

    private TextView nome;
    private RatingBar nota;
    private ImageView imagem;

    public PratoHolder(View cell) {
        super(cell);
        nome = cell.findViewById(R.id.prato_celula_nome);
        nota = cell.findViewById(R.id.prato_celula_nota);
        imagem = cell.findViewById(R.id.prato_celula_imagem);
    }

    public TextView getNome() {
        return nome;
    }

    public RatingBar getNota() {
        return nota;
    }

    public ImageView getImagem() {
        return imagem;
    }
}
