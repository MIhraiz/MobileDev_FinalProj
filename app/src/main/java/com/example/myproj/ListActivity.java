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
                "Computer Science","Faculty Of Engineering And Technology","Course to Learn Android","3" ,R.drawable.mobile1));

        course.add(new Course("Computer Networks","ENCS3320","Computer Systems Engineering","Faculty Of Engineering And Technology","Understand Computer Network consipts","3" ,R.drawable.network));

        course.add(new Course("General Biology LAB","BIO111","Biology","Faculty of Science","Making Experience","1",R.drawable.bio));

        course.add(new Course("Calculus","MATH1411","Mathematics","Faculty of Math","Review of Functions","4",R.drawable.math));

        // course.add(new Course("Men in black", R.drawable.mib,"Action"
        //,"Shoot","70Nis"));

        //course.add(new Course("Mario", R.drawable.mp,"Kids.",
        //      "Kids game","70Nis"));
//
//        course.add(new Course("Need for speed", R.drawable.ridealong,"racing.",
//                "racing game ","322Nis"));

//        movies.add(new Movie("Sijjin 2 ", R.drawable.sijjin2,"Horror.",
//                "A woman has had her little child squashed and killed after the jins have turned the cabinet over him as she found out that this was not a coincidence or a matter of death and life rather a malignant black magic has been hatched to hunt their family.","2015"));
//
//        movies.add(new Movie("Sijjin 6", R.drawable.sijjin6,"Horror",
//                "A girl is haunted by an evil spirit in her family home. Several bad things begin to happen around her house and to her family members. ","2019"));
//
//        movies.add(new Movie("Tahanji", R.drawable.tahanji,"Drama.",
//                "Tanhaji Malusare, a military chieftain in the army of the Maratha king Shivaji, leads the charge to capture the strategically important Kondhana fort guarded by the army of the fierce Rajput chieftain Udaybhan Rathod.","2020"));
//
//        movies.add(new Movie("The Conjuring", R.drawable.theconjuring,"Horror.",
//                "Paranormal investigators Ed and Lorraine Warren work to help a family terrorized by a dark presence in their farmhouse.","2013"));
    }
}