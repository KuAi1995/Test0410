package com.ysn.app_kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ysn.app_kotlin.R
import com.ysn.app_kotlin.data.App
import com.ysn.app_kotlin.data.CustomAdapter
import com.ysn.app_kotlin.data.Data

class RecyclerViewActivity : AppCompatActivity() {
    private var mRecyclerView: RecyclerView? = null
    private var mCustomAdapter: CustomAdapter? = null
    private val mAppsList: MutableList<App> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        init()
    }

    private fun init() {
        mRecyclerView = findViewById(R.id.recyclerView)
        // 构造一些数据
        for (i in 0..49) {
            val app = App()
            app.title = "标题$i"
            app.content = "内容$i"
            app.imageId = R.mipmap.ic_launcher
            mAppsList.add(app)
        }
        Data.instance.appsList = mAppsList
        mCustomAdapter = CustomAdapter()
        mRecyclerView?.setAdapter(mCustomAdapter)
        val layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
        mRecyclerView?.setLayoutManager(layoutManager)
    }
}