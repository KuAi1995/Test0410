package com.ysn.test0410.data;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ysn.test0410.R;

/**
 * 项目名称：Test0410
 * 创建人：fulin
 * 创建时间：2023/4/10 22:45
 * 类描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_list, null);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        App app = Data.getInstance().getAppsList().get(position);
        holder.mImageView.setImageResource(app.imageId);
        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "严嗣南真棒" + app.title, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        holder.mTitleTv.setText(app.title);
        holder.mTitleContent.setText(app.content);
    }

    @Override
    public int getItemCount() {
        return Data.getInstance().getAppsList().size();
    }
}
