package com.example.myproj;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproj.model.Sport;
import com.example.myproj.model.Sport;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    public static RecyclerViewClickListener recyclerViewClickListener;
    private Context context;
    private ArrayList<Sport> sport;

    public Adapter(Context context, ArrayList<Sport> sport, RecyclerViewClickListener recyclerViewClickListener){
        this.sport = sport;
        this.context = context;
        Adapter.recyclerViewClickListener = recyclerViewClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private CardView cardView;

        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            recyclerViewClickListener.recyclerViewListClicked(v, this.getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView card = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_image, parent, false);
        return new ViewHolder(card);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int index) {
        CardView cardView = holder.cardView;
        ImageView imageView = cardView.findViewById(R.id.image);

        Drawable dr = ContextCompat.getDrawable(cardView.getContext(), sport.get(index).getImageId());
        imageView.setImageDrawable(dr);

        TextView txt = cardView.findViewById(R.id.txtName);
        txt.setText(sport.get(index).getName());

        TextView price = cardView.findViewById(R.id.txtPrice);
        price.setText(sport.get(index).getPrice().substring(sport.get(index).getPrice().lastIndexOf(" ")));

        TextView rate = cardView.findViewById(R.id.txtRating);
        rate.setText(sport.get(index).getRate());

    }

    @Override
    public int getItemCount() {
        return sport.size();
    }

}