package com.ysn.app_kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ysn.app_kotlin.R
import com.ysn.app_kotlin.data.App
import com.ysn.app_kotlin.data.CustomAdapter
import com.ysn.app_kotlin.data.Data
import java.util.ArrayList

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
            app.appName = "xx应用$i"
            app.versionName = "100$i"
            app.appSize = 1.5 + i
            app.imagePath = "sdcard/AAAPUSH/ic_launcher.jpg"
            app.appIntroduction = "本应用是$i"
            app.timeUpdate = "2023年4月" + i % 30 + "日"
            mAppsList.add(app)
        }
        Data.instance.appsList = mAppsList
        mCustomAdapter = CustomAdapter()
        mRecyclerView?.adapter = mCustomAdapter
        val layoutManager = GridLayoutManager(this@RecyclerViewActivity, 3) // 每行3个
        //        layoutManager.setOrientation(RecyclerView.HORIZONTAL); // 设置横向滚动
        mRecyclerView?.layoutManager = layoutManager
    }
}