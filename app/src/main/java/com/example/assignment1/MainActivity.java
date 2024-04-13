package com.example.assignment1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

    CheckBox rem;

    Button submit;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    public static final String FLAG = "FLAG";
    boolean flag = false;
    int lvl ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);
        level3 = findViewById(R.id.level3);
        submit = findViewById(R.id.submit);
        rem    = findViewById(R.id.rem);
        setupSharedPrefs();
        checkPrefs();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level1.isChecked()){
                    if (level2.isChecked()||level3.isChecked()){
                        Toast.makeText(MainActivity.this,"Please Select only One !",Toast.LENGTH_LONG).show();
                        return;
                    }
                    if (rem.isChecked()){
                        if (!flag){
                            editor.putInt("lvl",1);
                            editor.putBoolean(FLAG,true);
                            editor.commit();
                        }
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
                    if (rem.isChecked()){
                        if (!flag){
                            editor.putInt("lvl",2);
                            editor.putBoolean(FLAG,true);
                            editor.commit();
                        }
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
                    if (rem.isChecked()){
                        if (!flag){
                            editor.putInt("lvl",3);
                            editor.putBoolean(FLAG,true);
                            editor.commit();
                        }
                    }
                    Intent intent = new Intent(MainActivity.this,SecActivity.class);
                    intent.putExtra("level","3");
                    startActivity(intent);
                }
            }
        });
    }
    private void setupSharedPrefs() {
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }
    private void checkPrefs() {
        flag = prefs.getBoolean(FLAG, false);

        if(flag){
                lvl = prefs.getInt("lvl",0);
                switch (lvl){
                    case 1:
                        level1.setChecked(true);
                        break;
                    case 2:
                        level2.setChecked(true);
                        break;
                    case 3:
                        level3.setChecked(true);
                        break;
                }
                editor.clear();
                editor.commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkPrefs();
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPrefs();
    }
}