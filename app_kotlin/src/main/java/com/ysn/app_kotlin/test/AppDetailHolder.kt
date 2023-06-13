package com.ysn.app_kotlin.test

import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.ysn.app_kotlin.R

/**
 * 项目名称：SSLauncher
 * 创建人：fulin
 * 创建时间：2023/5/15 22:07
 * 类描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 */
class AppDetailHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var mImageView: ImageView
    var mRootView: ConstraintLayout
    init {

        mImageView = itemView.findViewById(R.id.imageView)
        mRootView = itemView.findViewById(R.id.rootView)
    }
}