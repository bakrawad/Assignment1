package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class SecActivity extends AppCompatActivity {
    TextView level ;
    ListView levellist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sec);
        level = findViewById(R.id.level);
        levellist = findViewById(R.id.levellist);
        String lvl = (getIntent().getStringExtra("level"));
        String sub = level.getText().toString()+" "+ lvl;
        level.setText(sub);

        DataClass dc = new DataClass();
        List<Course> courses = dc.getCourse(Integer.parseInt(lvl));
        Course[] arr = courses.toArray(new Course[courses.size()]);
        ArrayAdapter<Course> adapter = new ArrayAdapter<>(SecActivity.this,
                android.R.layout.simple_list_item_1,arr);
        levellist.setAdapter(adapter);

        levellist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course clickedCourse = (Course) parent.getItemAtPosition(position);
                String clickedName = clickedCourse.name;
                String clickedSubject = clickedCourse.subject;
                Intent intent = new Intent(SecActivity.this,ThirdActivity2.class);
                intent.putExtra("course",clickedName);
                intent.putExtra("subject",clickedSubject);
                startActivity(intent);
            }
        });
    }
}