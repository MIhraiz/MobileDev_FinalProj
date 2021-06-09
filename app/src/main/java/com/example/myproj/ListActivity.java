package com.example.myproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.example.myproj.model.Sport;
import com.example.myproj.model.Sport;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    Adapter adapter;
    public static ArrayList<Sport> sport;
    Sport r = new Sport() ;
    private RecyclerViewClickListener recyclerViewClickListener;
    public int indexClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // create data to display
        loadData();

        //create listener for the recyclerView
        recyclerViewClickListener = new RecyclerViewClickListener() {
            @Override
            public void recyclerViewListClicked(View v, int position) {
                indexClicked = position;
                showDetails(v);
            }
        };

        RecyclerView recyclerView = findViewById(R.id.course_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, sport, recyclerViewClickListener);
        recyclerView.setAdapter(adapter);
    }

    public void showDetails(View view) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("index", indexClicked);
        startActivity(intent);
    }

    int unicode=0x2B50;
    int uni = 0x200D ;
    int code = 0x1F3CB ;
    int c = 0x1F6A3 ;
    int b = 0xFE0F ;
    int y = 0x1F938 ;
    int y2 = 0x1F9D8 ;
    int run = 0x1F3C3 ;
    String emoji = r.getEmoji(unicode) ;
    String bicycle = r.getEmoji(uni) ;
    String dumbbells = r.getEmoji(code) ;
    String boat = r.getEmoji(c) ;
    String ball = r.getEmoji(b) ;
    String yoga1 =  r.getEmoji(y) ;
    String yoga2 =  r.getEmoji(y2) ;
    String runn =  r.getEmoji(run) ;
    public void loadData() {
        sport = new ArrayList<>();

        sport.add(new Sport("Balls",
                "Description :balls section , Basketball , Football , volleyball " +ball ,emoji+emoji ,
                "Price : 20₪", R.drawable.balls));
        sport.add(new Sport("Bicycle",
                "Description : 18enc , made in Italy " + bicycle,emoji+emoji+emoji+emoji+emoji ,
                "Price : 200₪", R.drawable.by));
        sport.add(new Sport("dumbbells",
                "Description : 3kg , 5kg , 7kg " + dumbbells ,emoji+emoji+emoji ,
                "Price : 50₪", R.drawable.dumb));
        sport.add(new Sport("Yoga mats",
                "Description : available in purple , pink and yellow " + yoga1 ,emoji ,
                "Price : 30₪", R.drawable.yoga));
        sport.add(new Sport("boots",
                "Description : Nike and Adidas  ",emoji+emoji+emoji+emoji ,
                "Price : 120₪", R.drawable.boots));
        sport.add(new Sport("Running Machine",
                "Description : Made in America" +runn,emoji+emoji ,
                "Price : 300₪", R.drawable.machine));
        sport.add(new Sport("Yoga equipments",
                "Description : small dumbbells , mats " +yoga2,emoji+emoji+emoji ,
                "Price : 150₪", R.drawable.yy));
        sport.add(new Sport("boat",
                "Description : River boat " + boat,emoji+emoji+emoji+emoji+emoji ,
                "Price : 400₪", R.drawable.boat));





        /*course.add(new Course("Computer Networks","ENCS3320",
                "Computer Systems Engineering","Faculty Of Engineering And Technology",
                "Understand Computer Network consipts","3" ,R.drawable.network));

        course.add(new Course("General Biology LAB","BIO111","Biology",
                "Faculty of Science","Making Experience","1",R.drawable.bio));

        course.add(new Course("Calculus","MATH1411","Mathematics",
                "Faculty of Math","Review of Functions","4",R.drawable.math));

        course.add(new Course("Fundamentals Of Nursing","MNURS1221","Nursing",
                "Faculty of Pharmacy, Nursing and Health Professions",
                "Learn the basic information about nursing","3",R.drawable.cartoon));

        course.add(new Course("Architectural Drawings","ENAR1211","Architecture",
                "Faculty of Engineering",
                "Learn the technical drawing of a building ","3",R.drawable.d));

        course.add(new Course("Mechanics","ENCE223","civil engineering",
                "Faculty of Engineering",
                "Learn the technical Machines","3",R.drawable.b));

        course.add(new Course("Music Notation Software Skills ","MUSI226",
                "Arts","Arabic music",
                "Knowledge about the basis of Arabic music","3",R.drawable.piano));

     *//*   course.add(new Course("International Poplitical Economy","PHSS9350",
                "Social Science","Faculty of Economy",
                "Knowledge about the details in economy world","3",R.drawable.stack));*//*

        course.add(new Course("Dissertation","PHSS9350","Social Science",
                "Faculty of Economy",
                "learn how to write essay on a  economy","3",R.drawable.nerd));

    }*/
    }
}