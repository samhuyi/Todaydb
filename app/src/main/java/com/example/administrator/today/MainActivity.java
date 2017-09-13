package com.example.administrator.today;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.administrator.today.R.id.rate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img= (ImageView) findViewById(R.id.day);
        ImageView gohibit= (ImageView) findViewById(R.id.goHabit);
       //
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,EditcustomActivity.class);
                startActivity(intent);
            }
        });
        //主界面跳转到HabitActivity
        gohibit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HabitActivity.class);
                startActivity(intent);
            }
        });
    }
}
