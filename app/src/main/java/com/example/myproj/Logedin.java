package com.example.myproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Logedin extends AppCompatActivity {

    private String user = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logedin);
        Intent intent3 = getIntent();
        user = intent3.getStringExtra("USER");
        System.out.println(user);
    }

    public void onClick_UpdateFormbtn(View view) {
        Intent intent2 = new Intent(this, UpdateForm.class);
        intent2.putExtra("USER", user);
        startActivity(intent2);

    }
}