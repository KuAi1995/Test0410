package com.ysn.app_kotlin.data

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.ysn.app_kotlin.R

/**
 * 项目名称：Test0410
 * 创建人：fulin
 * 创建时间：2023/4/10 22:46
 * 类描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mImageView: ImageView
    var appName: TextView
    var appContent: TextView
    var mButton: Button
    var mRootView: ConstraintLayout

    init {
        mImageView = itemView.findViewById(R.id.imageView)
        appName = itemView.findViewById(R.id.textView)
        appContent = itemView.findViewById(R.id.textView2)
        mButton = itemView.findViewById(R.id.button2)
        mRootView = itemView.findViewById(R.id.rootView)
    }
}