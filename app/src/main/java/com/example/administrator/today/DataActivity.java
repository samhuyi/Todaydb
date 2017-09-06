package com.example.administrator.today;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wingjay.blurimageviewlib.BlurImageView;

public class DataActivity extends AppCompatActivity {

    private String blurImageUrl = "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1242746736,1100844489&fm=27&gp=0.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        setBackground();
    }

    private void setBackground(){
        BlurImageView blurImageView =(BlurImageView)findViewById(R.id.background);
        blurImageView.setBlurImageByUrl(blurImageUrl);
        blurImageView.setBlurFactor(50);
    }
}
