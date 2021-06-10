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
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Proceed extends AppCompatActivity {

    CartAdapter cartAdapter;
    RecyclerView recyclerView;
    ArrayList<CartItem> cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceed);
        Button pr = findViewById(R.id.total_price);
        Button btnTax = findViewById(R.id.tax);
        Button totalTax = findViewById(R.id.total_price_tax);


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

            double price = 0;
            for (CartItem i :cartItems){
                String temp = i.getPrice();
                int t = Integer.parseInt(temp.substring(temp.lastIndexOf(" "),temp.length()-1).trim());
                price += t;
            }
            DecimalFormat df2 = new DecimalFormat("#.##");

            String p ="Total Price: " + df2.format(price) + "₪";
            pr.setText(p);

            p = "Total Tax: " + df2.format( price*0.14) + "₪";
            btnTax.setText(p);

            totalTax.setText("Total Price With Tax: " + df2.format(price + price*0.14) + "₪");

        } else {
            pr.setText("Total Price:  00.00₪");
            btnTax.setText("Tax: 0.0₪");
            totalTax.setText("Total Price With Tax: 00.00₪" );
        }
    }
}