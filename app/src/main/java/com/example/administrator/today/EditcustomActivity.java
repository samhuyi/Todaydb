package com.example.administrator.today;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class EditcustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editcustom);
        ImageView backactivity= (ImageView) findViewById(R.id.backActivity);
        backactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditcustomActivity.this.finish();
            }
        });
    }
}
