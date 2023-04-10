package com.ysn.test0410.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ysn.test0410.R;
import com.ysn.test0410.data.App;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;
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
        mMyAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mMyAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(RecyclerViewActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHoder> {

        @NonNull
        @Override
        public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(RecyclerViewActivity.this, R.layout.item_list, null);
            MyViewHoder myViewHoder = new MyViewHoder(view);
            return myViewHoder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHoder holder, int position) {
            App app = mAppsList.get(position);
            holder.mImageView.setImageResource(app.imageId);
            holder.mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast toast = Toast.makeText(RecyclerViewActivity.this, "严嗣南真棒" + app.title, Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
            holder.mTitleTv.setText(app.title);
            holder.mTitleContent.setText(app.content);
        }

        @Override
        public int getItemCount() {
            return mAppsList.size();
        }
    }

    class MyViewHoder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTitleTv;
        TextView mTitleContent;
        Button mButton;

        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTitleTv = itemView.findViewById(R.id.textView);
            mTitleContent = itemView.findViewById(R.id.textView2);
            mButton = itemView.findViewById(R.id.button2);
        }
    }
}