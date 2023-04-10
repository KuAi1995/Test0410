package com.ysn.test0410.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ysn.test0410.R;
import com.ysn.test0410.data.App;
import com.ysn.test0410.data.CustomAdapter;
import com.ysn.test0410.data.Data;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
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
            App app = new App();
            app.title = "标题" + i;
            app.content = "内容" + i;
            app.imageId = R.mipmap.ic_launcher;
            mAppsList.add(app);
        }
        Data.getInstance().setAppsList(mAppsList);
        mCustomAdapter = new CustomAdapter();
        mRecyclerView.setAdapter(mCustomAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(RecyclerViewActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
    }
}