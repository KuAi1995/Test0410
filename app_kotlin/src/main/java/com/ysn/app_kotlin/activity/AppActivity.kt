package com.ysn.app_kotlin.activity

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.ysn.app_kotlin.R

class AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        init()
    }

    @SuppressLint("SetTextI18n")
    private fun init() {
        val imageViewApp = findViewById<ImageView>(R.id.imageViewApp)
        val imageViewApp1 = findViewById<ImageView>(R.id.imageViewApp1)
        val imageViewApp2 = findViewById<ImageView>(R.id.imageViewApp2)
        val imageViewApp3 = findViewById<ImageView>(R.id.imageViewApp3)
        imageViewApp.setImageResource(R.mipmap.ic_launcher)
        imageViewApp1.setImageResource(R.mipmap.ic_launcher)
        imageViewApp2.setImageResource(R.mipmap.ic_launcher)
        imageViewApp3.setImageResource(R.mipmap.ic_launcher)
        val textViewAppName = findViewById<TextView>(R.id.textViewAppName)
        val textViewDetails = findViewById<TextView>(R.id.textViewDetails)
        val textViewAppIntroduction = findViewById<TextView>(R.id.textViewAppIntroduction)
        val textViewVersionName = findViewById<TextView>(R.id.textViewVersionName)
        val textViewAppSize = findViewById<TextView>(R.id.textViewAppSize)
        val textViewTimeUpdate = findViewById<TextView>(R.id.textViewTimeUpdate)
        val intent = intent
        if (intent != null) {
            imageViewApp.setImageURI(Uri.parse(intent.getStringExtra("imagePath")))
            textViewAppName.text = intent.getStringExtra("appName")
            textViewDetails.text = ("版本" + intent.getStringExtra("versionName")
                    + "|大小" + intent.getDoubleExtra("appSize", 0.0) + "MB")
            textViewAppIntroduction.text = intent.getStringExtra("appIntroduction")
            textViewVersionName.text = "版本：" + intent.getStringExtra("versionName")
            textViewAppSize.text = "大小：" + intent.getDoubleExtra("appSize", 0.0) + "MB"
            textViewTimeUpdate.text = "更新时间：" + intent.getStringExtra("timeUpdate")
        }
    }
}