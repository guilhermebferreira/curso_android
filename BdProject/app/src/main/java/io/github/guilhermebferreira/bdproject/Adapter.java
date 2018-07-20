package io.github.guilhermebferreira.bdproject;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<RegHolder> {

    private Context context = null;
    private ArrayList<Reg> list = null;

    public Adapter(Context context, ArrayList<Reg> list){
        this.context = context;
        this.list = list;
    }



    @Override
    public RegHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View cell = LayoutInflater.from(context).inflate(R.layout.celula,
                parent,
                false);
        RegHolder holder = new RegHolder(cell);

        return holder;
    }


    public void onBindViewHolder( RegHolder holder, final int position) {
        final Reg reg = list.get(position);
        holder.getName().setText(reg.getName());
        holder.getImage().setImageBitmap(
                BitmapFactory.decodeFile(reg.getImagepath())
        );
        holder.getRating().setRating(reg.getRating());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Clicou no: " + reg.get_id() + " - " + reg.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.getDelete().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                list.remove(position);
                reg.delete(context);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
