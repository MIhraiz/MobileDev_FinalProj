package com.example.myproj;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.myproj.model.Course;


public class DetailsActivity extends AppCompatActivity {
    int index;
    private Course course = null;
    private ImageView img;
    private TextView name;
    private TextView description;
    private TextView dep;
    private TextView label;
    private TextView faculty;
    private TextView credit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        // get the course index to show it's details
        index = intent.getExtras().getInt("index");
        System.out.println(index);
        course = ListActivity.course.get(index);
        img = findViewById(R.id.imgD);
        label = findViewById(R.id.label);
        dep = findViewById(R.id.dep);
        faculty = findViewById(R.id.faculty);
        name = findViewById(R.id.nameD);
        description = findViewById(R.id.description);
        credit = findViewById(R.id.credit);

        displayData(course);
    }

    private void displayData(Course course) {
        Drawable dr = ContextCompat.getDrawable(this, course.getImageId());
        img.setImageDrawable(dr);
        name.setText(course.getName());
        description.setText(course.getDescription());
        label.setText(course.getLabel());
        faculty.setText(course.getFaculty());
        credit.setText(course.getCredit());
        dep.setText(course.getDep());
    }

    public void AddToSchedule(View view) {
        Toast.makeText(this, "             Coming soon.\nSee you in the next Project. :P", Toast.LENGTH_LONG).show();
    }
}
