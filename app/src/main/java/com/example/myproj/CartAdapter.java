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

import com.example.model.CartItem;
import com.example.myproj.model.Sport;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<CartItem> cartItems;

    public CartAdapter(Context context, ArrayList<CartItem> cartItems){
        this.cartItems = cartItems;
        this.context = context;
    }


    public class MyViewHolder  extends RecyclerView.ViewHolder{
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.cart_card,
                parent,
                false
        );
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        View itemView = holder.itemView;
        ImageView imageView = itemView.findViewById(R.id.cartimage);

        Drawable dr = ContextCompat.getDrawable(imageView.getContext(), cartItems.get(position).getImageID());
        imageView.setImageDrawable(dr);

        TextView name = itemView.findViewById(R.id.cartname);
        name.setText(cartItems.get(position).getName());

        TextView price = itemView.findViewById(R.id.cartprice);
        price.setText(cartItems.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }



}
