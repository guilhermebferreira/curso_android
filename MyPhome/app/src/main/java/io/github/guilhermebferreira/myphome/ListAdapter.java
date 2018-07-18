package io.github.guilhermebferreira.myphome;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<PratoHolder> {

    private Context context = null;
    private ArrayList<Prato> pratoList = null;

    public ListAdapter(Context context, ArrayList<Prato> pratoList){
        this.context = context;
        this.pratoList = pratoList;
    }



    @Override
    //quantas celulas preciso criar?
    public int getItemCount() {
        //retorna a quantidade de elementos que serão necesários gerar
        return pratoList.size();
    }

    @NonNull
    @Override
    public PratoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //metodo que cria N celulas
        View cell = LayoutInflater.from(context).inflate(R.layout.prato_celula, parent, false);
        PratoHolder holder = new PratoHolder(cell);
        return holder;
    }

    @Override
    //metodo que define com que informações a celula será preenchida
    public void onBindViewHolder(@NonNull PratoHolder holder, int position) {
        Prato prato = pratoList.get(position);
        holder.getNome().setText(prato.getNome());
        holder.getImagem().setImageResource(prato.getImagem());
        holder.getNota().setRating(((float) prato.getNota()));

    }
}
