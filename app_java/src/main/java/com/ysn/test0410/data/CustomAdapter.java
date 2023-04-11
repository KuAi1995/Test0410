package com.ysn.test0410.data;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ysn.test0410.R;
import com.ysn.test0410.activity.AppActivity;

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
    private static final String TAG = CustomAdapter.class.getSimpleName();

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_list, null);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        return customViewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        App app = Data.getInstance().getAppsList().get(position);
        Log.d(TAG, Uri.parse(app.imagePath).getPath());
        holder.mImageView.setImageURI(null);
        holder.mImageView.setImageURI(Uri.parse(app.imagePath));
        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AppActivity.class);
                intent.putExtra("imagePath", app.imagePath);
                intent.putExtra("appName", app.appName);
                intent.putExtra("versionName", app.versionName);
                intent.putExtra("appSize", app.appSize);
                intent.putExtra("appIntroduction", app.appIntroduction);
                intent.putExtra("timeUpdate", app.timeUpdate);
                v.getContext().startActivity(intent);
            }
        });
        holder.mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AppActivity.class);
                intent.putExtra("imagePath", app.imagePath);
                intent.putExtra("appName", app.appName);
                intent.putExtra("versionName", app.versionName);
                intent.putExtra("appSize", app.appSize);
                intent.putExtra("appIntroduction", app.appIntroduction);
                intent.putExtra("timeUpdate", app.timeUpdate);
                v.getContext().startActivity(intent);
            }
        });
        holder.appName.setText(app.appName);
        holder.appContent.setText("版本" + app.versionName + "|" + app.appSize + "MB");
    }

    @Override
    public int getItemCount() {
        return Data.getInstance().getAppsList().size();
    }
}
