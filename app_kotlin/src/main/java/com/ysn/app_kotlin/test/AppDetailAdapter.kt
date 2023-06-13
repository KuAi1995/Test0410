package com.ysn.app_kotlin.test

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ysn.app_kotlin.R

/**
 * 项目名称：SSLauncher
 * 创建人：fulin
 * 创建时间：2023/5/15 22:20
 * 类描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 */
class AppDetailAdapter : RecyclerView.Adapter<AppDetailHolder>() {

    private val urls = ArrayList<String>()

    fun setData(appList: List<String>) {
        urls.clear()
        urls.addAll(appList)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AppDetailHolder {
        val view =
            View.inflate(parent.context, R.layout.appstore_detail_item, null)
        return AppDetailHolder(view)

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AppDetailHolder, position: Int) {

        Log.d("ysn", "1111111111")

        // val appImage = urls[position]
        val appImage = AppDetail.instance.urls

        Glide.with(holder.mImageView.context).asBitmap().load(Uri.parse("https://img-blog.csdnimg.cn/faa68ab1f57546e7b4d67e3b146d8f37.png#pic_center"))
            .skipMemoryCache(true)
            .diskCacheStrategy(
                DiskCacheStrategy.ALL
            ).override(200, 200)
            .into(holder.mImageView)

        holder.mImageView.setImageResource(R.mipmap.ic_launcher)

    }

    override fun getItemCount(): Int {
        return AppDetail.instance.urls.size
    }
}