package com.ysn.app_kotlin.activity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ysn.app_kotlin.R
import com.ysn.test0409.data.App

class RecyclerViewActivity : AppCompatActivity() {
    private var mRecyclerView: RecyclerView? = null
    private var mMyAdapter: MyAdapter? = null
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
        mMyAdapter = MyAdapter()
        mRecyclerView?.setAdapter(mMyAdapter)
        val layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
        mRecyclerView?.setLayoutManager(layoutManager)
    }

    internal inner class MyAdapter : RecyclerView.Adapter<MyViewHoder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHoder {
            val view =
                View.inflate(this@RecyclerViewActivity, R.layout.item_list, null)
            return MyViewHoder(view)
        }

        override fun onBindViewHolder(holder: MyViewHoder, position: Int) {
            val app = mAppsList[position]
            holder.mImageView.setImageResource(app.imageId)
            holder.mButton.setOnClickListener {
                val toast = Toast.makeText(
                    this@RecyclerViewActivity,
                    "严嗣南真棒" + app.title,
                    Toast.LENGTH_SHORT
                )
                toast.show()
            }
            holder.mTitleTv.text = app.title
            holder.mTitleContent.text = app.content
        }

        override fun getItemCount(): Int {
            return mAppsList.size
        }
    }

    internal inner class MyViewHoder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mImageView: ImageView
        var mTitleTv: TextView
        var mTitleContent: TextView
        var mButton: Button

        init {
            mImageView = itemView.findViewById(R.id.imageView)
            mTitleTv = itemView.findViewById(R.id.textView)
            mTitleContent = itemView.findViewById(R.id.textView2)
            mButton = itemView.findViewById(R.id.button2)
        }
    }
}