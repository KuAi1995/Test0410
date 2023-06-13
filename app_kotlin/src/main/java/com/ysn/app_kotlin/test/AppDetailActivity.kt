package com.ysn.app_kotlin.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ysn.app_kotlin.R

class AppDetailActivity : AppCompatActivity() {

    private var mRecyclerView: RecyclerView? = null
    private val mUrls = ArrayList<String>()
    private var mAppDetailAdapter: AppDetailAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_detail)

        mRecyclerView = findViewById(R.id.app_detail_recyclerview)


        mUrls.add("https://img-blog.csdnimg.cn/img_convert/9f853a4a51dc586eda2b5e5216cbba21.png")
        mUrls.add("https://img-blog.csdnimg.cn/img_convert/9f853a4a51dc586eda2b5e5216cbba21.png")
        mUrls.add("https://img-blog.csdnimg.cn/img_convert/9f853a4a51dc586eda2b5e5216cbba21.png")
        mUrls.add("https://img-blog.csdnimg.cn/img_convert/9f853a4a51dc586eda2b5e5216cbba21.png")
        mUrls.add("https://img-blog.csdnimg.cn/img_convert/9f853a4a51dc586eda2b5e5216cbba21.png")
        mUrls.add("https://img-blog.csdnimg.cn/img_convert/9f853a4a51dc586eda2b5e5216cbba21.png")
        mUrls.add("https://img-blog.csdnimg.cn/img_convert/9f853a4a51dc586eda2b5e5216cbba21.png")

        AppDetail.instance.urls = mUrls
        // mAppDetailAdapter.setData(mUrls)
        mAppDetailAdapter = AppDetailAdapter()
        mRecyclerView?.adapter = mAppDetailAdapter
        val layoutManager = GridLayoutManager(this@AppDetailActivity, 1) // 每行1个
        layoutManager.orientation = RecyclerView.HORIZONTAL
        mRecyclerView?.layoutManager = layoutManager
    }
}