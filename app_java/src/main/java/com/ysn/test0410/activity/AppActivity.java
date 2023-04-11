package com.ysn.test0410.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.ysn.test0410.R;

public class AppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        init();
    }

    private void init() {
        ImageView imageViewApp = findViewById(R.id.imageViewApp);
        ImageView imageViewApp1 = findViewById(R.id.imageViewApp1);
        ImageView imageViewApp2 = findViewById(R.id.imageViewApp2);
        ImageView imageViewApp3 = findViewById(R.id.imageViewApp3);
        imageViewApp.setImageResource(R.mipmap.ic_launcher);
        imageViewApp1.setImageResource(R.mipmap.ic_launcher);
        imageViewApp2.setImageResource(R.mipmap.ic_launcher);
        imageViewApp3.setImageResource(R.mipmap.ic_launcher);
    }
}