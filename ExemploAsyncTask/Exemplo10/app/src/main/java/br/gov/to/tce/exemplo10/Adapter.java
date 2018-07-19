/****************************************************************
 * Nome: Exemplo10
 * Descrição: demonstra o uso de alertas e componentes visuais
 * Autor: Silvano Malfatti
 * Data: 16/07/2018
 *****************************************************************/

//Pacote da aplicação
package br.gov.to.tce.exemplo10;

//Pacotes utilizados
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<FoodHolder>
{
    private Context context;
    private ArrayList<Food> foodList;
    private OnClickList onClickListener = null;

    public Adapter(Context context, ArrayList<Food> foodList, OnClickList onClickListener)
    {
        this.context = context;
        this.foodList = foodList;
        this.onClickListener = onClickListener;
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    @Override
    public FoodHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View cell = LayoutInflater.from(context).inflate(R.layout.layout_cell, parent, false);

        FoodHolder holder = new FoodHolder(cell);

        return holder;

    }

    @Override
    public void onBindViewHolder(final FoodHolder holder, final int position)
    {
        Food food = foodList.get(position);
        holder.getName().setText(food.getFoodName());
        holder.getStars().setRating( Float.parseFloat(food.getClassification()));

        //usando o picasso para baixar as imagens por meio de threads individuais
        Picasso.with(context).load(food.getImage()).into(holder.getImage());
        //holder.getImage().setImageBitmap(food.getImage());

        /*holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                onClickListener.onClickCell(holder.itemView, position);
            }
        });*/
    }
}
