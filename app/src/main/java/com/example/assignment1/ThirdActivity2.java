package com.example.assignment1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity2 extends AppCompatActivity {
    TextView course ;
    TextView subject;
    TextView titel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third2);
        course = findViewById(R.id.course);
        subject = findViewById(R.id.subject);
        titel = findViewById(R.id.titel);

        String cou = course.getText().toString() + " " + getIntent().getStringExtra("course");
        titel.setText(getIntent().getStringExtra("subject"));
        course.setText(cou);
    }
}