package com.example.myproj;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.myproj.model.Sport;
import com.example.myproj.model.Sport;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class DetailsActivity extends AppCompatActivity {
    int index;
    private Sport sport = null;
    private ImageView img;
    private TextView name;
    private TextView description;
    private TextView price;
    private TextView rate;
    ArrayList<Sport> sportArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        // get the course index to show it's details
        index = intent.getExtras().getInt("index");
        System.out.println(index);
        sport = ListActivity.sport.get(index);
        img = findViewById(R.id.imgD);
        name = findViewById(R.id.nameD);
        description = findViewById(R.id.description);
        price = findViewById(R.id.price);
        rate = findViewById(R.id.rate);

        displayData(sport);
        loadData();
    }

    private void displayData(Sport sport) {
        Drawable dr = ContextCompat.getDrawable(this, sport.getImageId());
        img.setImageDrawable(dr);
        name.setText(sport.getName());
        description.setText(sport.getDescription());
        price.setText(sport.getPrice());
        rate.setText(sport.getRate());
    }
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(sportArray);
        editor.putString("task list", json);
        editor.apply();
        Toast.makeText(DetailsActivity.this,"saved",Toast.LENGTH_LONG).show();
    }
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<Sport>>() {}.getType();
        sportArray = gson.fromJson(json, type);
        if (sportArray == null) {
            sportArray = new ArrayList<>();

        }
     Toast.makeText(DetailsActivity.this,"loaded",Toast.LENGTH_LONG).show();

    }
    public void AddToCart(View view) {
        saveData();
    }
    public void ViewCart(View view) {
    }


}
