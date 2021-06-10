package com.example.myproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.model.CartItem;
import com.example.myproj.model.Sport;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CartView extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<CartItem> cartItems;
    ArrayList<Sport> sportArray;
    CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_view);
        recyclerView = findViewById(R.id.cart_rec);
        cartItems = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<Sport>>() {}.getType();
        sportArray = gson.fromJson(json, type);

        if(sportArray != null){
            for(Sport s :sportArray){
                cartItems.add(new CartItem(s.getName(), s.getPrice(), s.getImageId()));
            }
            cartAdapter = new CartAdapter(this, cartItems);
            recyclerView.setAdapter(cartAdapter);
        } else {
            cartItems = null;
        }


    }

    public void OnClick_Proceed(View view) {
        Intent intent = new Intent(this,Proceed.class);
        if(cartItems != null){
            Gson gson = new Gson();
            String json = gson.toJson(cartItems);
            intent.putExtra("Cart", json);
        }
        startActivity(intent);
    }

    public void OnClick_ClearCart(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        sportArray = null;
        String json = gson.toJson((Object) null);
        editor.putString("task list", json);
        editor.apply();
        finish();
        startActivity(getIntent());
    }
}




