package io.github.guilhermebferreira.bdproject;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class RegHolder extends RecyclerView.ViewHolder {

    private ImageView image = null;
    private TextView name = null;
    private RatingBar rating = null;

    private FloatingActionButton delete = null;

    public RegHolder(View cell) {
        super(cell);
        name = cell.findViewById(R.id.celulaTextView);
        rating = cell.findViewById(R.id.celulaRatingBar);
        image = cell.findViewById(R.id.celulaImageView);
        delete = cell.findViewById(R.id.celulaDeleteButton);
    }


    public ImageView getImage() {
        return image;
    }

    public TextView getName() {
        return name;
    }

    public RatingBar getRating() {
        return rating;
    }

    public FloatingActionButton getDelete() {
        return delete;
    }

}
