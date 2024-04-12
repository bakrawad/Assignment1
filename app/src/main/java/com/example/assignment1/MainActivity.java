package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CheckBox level1;
    CheckBox level2;
    CheckBox level3;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);
        level3 = findViewById(R.id.level3);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level1.isChecked()){
                    if (level2.isChecked()||level3.isChecked()){
                        Toast.makeText(MainActivity.this,"Please Select only One !",Toast.LENGTH_LONG).show();
                        return;
                    }
                    Intent intent = new Intent(MainActivity.this,SecActivity.class);
                    intent.putExtra("level","1");
                    startActivity(intent);
                }
                if (level2.isChecked()){
                    if (level1.isChecked()||level3.isChecked()){
                        Toast.makeText(MainActivity.this,"Please Select only One !",Toast.LENGTH_LONG).show();
                        return;
                    }
                    Intent intent = new Intent(MainActivity.this,SecActivity.class);
                    intent.putExtra("level","2");
                    startActivity(intent);
                }
                if (level3.isChecked()){
                    if (level2.isChecked()||level1.isChecked()){
                        Toast.makeText(MainActivity.this,"Please Select only One !",Toast.LENGTH_LONG).show();
                        return;
                    }
                    Intent intent = new Intent(MainActivity.this,SecActivity.class);
                    intent.putExtra("level","3");
                    startActivity(intent);
                }
            }
        });
    }

}