package com.ysn.app_kotlin.fastAdapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.ysn.app_kotlin.R
import java.util.ArrayList

class FastAdapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fast_adapter)

        val itemAdapter = ItemAdapter<SimpleItem>()
        val fastAdapter = FastAdapter.with(itemAdapter)

        val recyclerView: RecyclerView? = findViewById(R.id.rv)
        recyclerView?.adapter = fastAdapter
        val layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView?.layoutManager = layoutManager

        val items = ArrayList<SimpleItem>()
        for (i in 0..50) {
            val simpleItem: SimpleItem = SimpleItem()
            simpleItem.name = "name $i"
            simpleItem.description = "description $i"
            items.add(simpleItem)
        }
        itemAdapter.add(items)
    }
}