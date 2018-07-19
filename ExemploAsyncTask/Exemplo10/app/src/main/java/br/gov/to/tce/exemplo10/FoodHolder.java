/****************************************************************
 * Nome: Exemplo10
 * Descrição: demonstra o uso de alertas e componentes visuais
 * Autor: Silvano Malfatti
 * Data: 16/07/2018
 *****************************************************************/

//Pacote da aplicação
package br.gov.to.tce.exemplo10;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class FoodHolder extends RecyclerView.ViewHolder
{
    private TextView name;
    private RatingBar stars;
    private ImageView image;

    public FoodHolder(View cell)
    {
        super(cell);
        name = cell.findViewById(R.id.cell_textView);
        stars = cell.findViewById(R.id.cell_rating);
        image = cell.findViewById(R.id.cell_image);
    }

    public TextView getName() {
        return name;
    }

    public RatingBar getStars() {
        return stars;
    }

    public ImageView getImage() {
        return image;
    }
}
