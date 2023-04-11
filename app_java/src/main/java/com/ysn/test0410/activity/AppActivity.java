package com.ysn.test0410.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysn.test0410.R;

public class AppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        init();
    }

    @SuppressLint("SetTextI18n")
    private void init() {
        ImageView imageViewApp = findViewById(R.id.imageViewApp);
        ImageView imageViewApp1 = findViewById(R.id.imageViewApp1);
        ImageView imageViewApp2 = findViewById(R.id.imageViewApp2);
        ImageView imageViewApp3 = findViewById(R.id.imageViewApp3);
        imageViewApp.setImageResource(R.mipmap.ic_launcher);
        imageViewApp1.setImageResource(R.mipmap.ic_launcher);
        imageViewApp2.setImageResource(R.mipmap.ic_launcher);
        imageViewApp3.setImageResource(R.mipmap.ic_launcher);
        TextView textViewAppName = findViewById(R.id.textViewAppName);
        TextView textViewDetails = findViewById(R.id.textViewDetails);
        TextView textViewAppIntroduction = findViewById(R.id.textViewAppIntroduction);
        TextView textViewVersionName = findViewById(R.id.textViewVersionName);
        TextView textViewAppSize = findViewById(R.id.textViewAppSize);
        TextView textViewTimeUpdate = findViewById(R.id.textViewTimeUpdate);
        Intent intent = getIntent();
        if (intent != null) {
            imageViewApp.setImageURI(Uri.parse(intent.getStringExtra("imagePath")));
            textViewAppName.setText(intent.getStringExtra("appName"));
            textViewDetails.setText("版本" + intent.getStringExtra("versionName")
                    + "|大小"+ intent.getDoubleExtra("appSize", 0.0) + "MB");
            textViewAppIntroduction.setText(intent.getStringExtra("appIntroduction"));
            textViewVersionName.setText("版本：" + intent.getStringExtra("versionName"));
            textViewAppSize.setText("大小：" + intent.getDoubleExtra("appSize", 0.0) + "MB");
            textViewTimeUpdate.setText("更新时间：" + intent.getStringExtra("timeUpdate"));
        }
    }
}