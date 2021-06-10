package com.example.myproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.model.CartItem;
import com.example.myproj.model.Sport;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Proceed extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<CartItem> cartItems;
    CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceed);
        Button pr = findViewById(R.id.total_price);

        Intent intent = getIntent();
        if(intent.hasExtra("Cart")){
            recyclerView = findViewById(R.id.cart_proceed);
            cartItems = new ArrayList<>();

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setHasFixedSize(true);

            Gson gson = new Gson();
            String json = intent.getStringExtra("Cart");
            Type type = new TypeToken<ArrayList<CartItem>>() {}.getType();
            cartItems = gson.fromJson(json, type);

            cartAdapter = new CartAdapter(this, cartItems);
            recyclerView.setAdapter(cartAdapter);

            int price = 0;
            for (CartItem i :cartItems){
                System.out.println(i.getPrice());
                String temp = i.getPrice();
                System.out.println(temp.trim() + "              s" + temp.substring(temp.lastIndexOf(" "),temp.length()-1).trim());
                int t = Integer.parseInt(temp.substring(temp.lastIndexOf(" "),temp.length()-1).trim());
                price += t;
            }
            String p = price + "₪";
            pr.setText(p);

        } else {
            pr.setText("0000₪");
        }
    }
}