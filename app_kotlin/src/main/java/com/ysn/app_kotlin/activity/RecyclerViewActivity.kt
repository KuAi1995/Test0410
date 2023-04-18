package com.ysn.app_kotlin.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.ysn.app_kotlin.R
import com.ysn.app_kotlin.data.App
import com.ysn.app_kotlin.data.CustomAdapter
import com.ysn.app_kotlin.data.Data
import java.io.*
import java.nio.charset.StandardCharsets

class RecyclerViewActivity : AppCompatActivity() {
    private val TAG: String = "RecyclerViewActivity"
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
            val jsonObject = load("contents.json")
            app.appName = jsonObject!!["appName"].toString() + i
            app.versionName = jsonObject["versionName"].toString() + i
            app.appSize = jsonObject["appSize"].toString().toDouble() + i
            app.imagePath = "sdcard/AAAPUSH/ic_launcher.jpg"
            app.appIntroduction = "本应用是$i"
            app.timeUpdate = "2023年4月" + i % 30 + "日"
            mAppsList.add(app)
        }
        Data.instance.appsList = mAppsList
        mCustomAdapter = CustomAdapter()
        mRecyclerView?.adapter = mCustomAdapter
        val layoutManager = GridLayoutManager(this@RecyclerViewActivity, 3) // 每行3个
        mRecyclerView?.layoutManager = layoutManager
    }

    private fun load(fileName: String): JsonObject? {
        var json = ""
        try {
            val inputStream = this.assets.open(fileName)
            val writer: Writer = StringWriter()
            val buffer = CharArray(inputStream.available())
            val reader: Reader =
                BufferedReader(InputStreamReader(inputStream, StandardCharsets.UTF_8))
            var n: Int
            while (reader.read(buffer).also { n = it } != -1) {
                Log.d(TAG, "load n=$n")
                writer.write(buffer, 0, n)
            }
            json = writer.toString()
        } catch (e: Exception) {
            Log.e(TAG, "load json error: " + e.message)
        }
        return Gson().fromJson(json, JsonObject::class.java)
    }
}