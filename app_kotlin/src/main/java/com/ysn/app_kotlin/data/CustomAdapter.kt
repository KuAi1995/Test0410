package com.ysn.app_kotlin.data

import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ysn.app_kotlin.R

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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view =
            View.inflate(parent.context, R.layout.item_list, null)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val app: App = Data.instance.appsList.get(position)
        holder.mImageView.setImageResource(app.imageId)
        holder.mButton.setOnClickListener { v ->
            val toast = Toast.makeText(v.context, "严嗣南真棒" + app.title, Toast.LENGTH_SHORT)
            toast.show()
        }
        holder.mTitleTv.text = app.title
        holder.mTitleContent.text = app.content
    }

    override fun getItemCount(): Int {
        return Data.instance.appsList.size
    }
}