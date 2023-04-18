package com.ysn.test0410.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ysn.test0410.R;
import com.ysn.test0410.data.App;
import com.ysn.test0410.data.CustomAdapter;
import com.ysn.test0410.data.Data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private static final String TAG = RecyclerViewActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private CustomAdapter mCustomAdapter;
    private List<App> mAppsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        init();
    }

    private void init() {
        mRecyclerView = findViewById(R.id.recyclerView);
        // 构造一些数据
        for (int i = 0; i < 50; i++) {
            JsonObject jsonObject = load("contents.json");
            App app = new App();
//            app.appName = "xx应用" + i;
//            app.versionName = "100" + i;
//            app.appSize = 1.5 + i;
//            app.imagePath = "sdcard/AAAPUSH/ic_launcher.jpg";
//            app.appIntroduction = "本应用是" + i;
//            app.timeUpdate = "2023年4月" + i % 30 + "日";
            app.appName = jsonObject.get("appName").toString() + i;
            app.versionName = jsonObject.get("versionName").toString() + i;
            app.appSize = Double.parseDouble(jsonObject.get("appSize").toString()) + i;
            app.imagePath = "sdcard/AAAPUSH/ic_launcher.jpg";
            app.appIntroduction = "本应用是" + i;
            app.timeUpdate = "2023年4月" + i % 30 + "日";
            mAppsList.add(app);
        }
        Data.getInstance().setAppsList(mAppsList);
        mCustomAdapter = new CustomAdapter();
        mRecyclerView.setAdapter(mCustomAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(RecyclerViewActivity.this, 3); // 每行3个
//        layoutManager.setOrientation(RecyclerView.HORIZONTAL); // 设置横向滚动
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private JsonObject load(String fileName) {
        String json = "";

        try {
//            InputStream inputStream = getResources().openRawResource(id);
            InputStream inputStream = this.getAssets().open(fileName);
            Writer writer = new StringWriter();
            char[] buffer = new char[inputStream.available()];
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                Log.d(TAG, "load n=" + n);
                writer.write(buffer, 0, n);
            }

            json = writer.toString();
        } catch (Exception e) {
            Log.e(TAG, "load json error: " + e.getMessage());
        }

        return new Gson().fromJson(json, JsonObject.class);
    }
}