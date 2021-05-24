package com.example.myproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.myproj.model.Course;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    Adapter adapter;
    public static ArrayList<Course> course;
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
        adapter = new Adapter(this,course,recyclerViewClickListener);
        recyclerView.setAdapter(adapter);
    }

    public void showDetails(View view){
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("index",indexClicked);
        startActivity(intent);
    }

    public void loadData(){
        course = new ArrayList<>();

        course.add(new Course("Mobile Application Development", "COMP438",
                "Computer Science","Faculty Of Engineering And Technology",
                "Course to Learn Android","3" ,R.drawable.mobile1));

        course.add(new Course("Computer Networks","ENCS3320",
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

        course.add(new Course("International Poplitical Economy","PHSS9350",
                "Social Science","Faculty of Economy",
                "Knowledge about the details in economy world","3",R.drawable.stack));

        course.add(new Course("Dissertation","PHSS9350","Social Science",
                "Faculty of Economy",
                "learn how to write essay on a  economy","3",R.drawable.nerd));

    }
}