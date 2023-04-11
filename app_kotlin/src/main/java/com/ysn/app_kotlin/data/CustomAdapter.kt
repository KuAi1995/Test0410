package com.ysn.app_kotlin.data

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ysn.app_kotlin.R
import com.ysn.app_kotlin.activity.AppActivity

/**
 * 项目名称：Test0410
 * 创建人：fulin
 * 创建时间：2023/4/10 22:45
 * 类描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
class CustomAdapter : RecyclerView.Adapter<CustomViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val view =
            View.inflate(parent.context, R.layout.item_list, null)
        return CustomViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val app = Data.instance.appsList[position]
        Log.d(TAG, Uri.parse(app.imagePath).path!!)
        holder.mImageView.setImageURI(null)
        holder.mImageView.setImageURI(Uri.parse(app.imagePath))
        holder.mButton.setOnClickListener { v ->
            val intent = Intent(v.context, AppActivity::class.java)
            intent.putExtra("imagePath", app.imagePath)
            intent.putExtra("appName", app.appName)
            intent.putExtra("versionName", app.versionName)
            intent.putExtra("appSize", app.appSize)
            intent.putExtra("appIntroduction", app.appIntroduction)
            intent.putExtra("timeUpdate", app.timeUpdate)
            v.context.startActivity(intent)
        }
        holder.mRootView.setOnClickListener { v ->
            val intent = Intent(v.context, AppActivity::class.java)
            intent.putExtra("imagePath", app.imagePath)
            intent.putExtra("appName", app.appName)
            intent.putExtra("versionName", app.versionName)
            intent.putExtra("appSize", app.appSize)
            intent.putExtra("appIntroduction", app.appIntroduction)
            intent.putExtra("timeUpdate", app.timeUpdate)
            v.context.startActivity(intent)
        }
        holder.appName.text = app.appName
        holder.appContent.text = "版本" + app.versionName + "|" + app.appSize + "MB"
    }

    override fun getItemCount(): Int {
        return Data.instance.appsList.size
    }

    companion object {
        private val TAG = CustomAdapter::class.java.simpleName
    }
}