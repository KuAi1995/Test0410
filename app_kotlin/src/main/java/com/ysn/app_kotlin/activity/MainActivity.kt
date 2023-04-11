package com.ysn.app_kotlin.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.ysn.app_kotlin.R
import java.util.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val permissions = arrayOf(
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    private val mPermissionList: MutableList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    @SuppressLint("NonConstantResourceId")
    override fun onClick(view: View) {
        when (view.id) {
            R.id.button -> checkPermissionAndToActivity()
            else -> {}
        }
    }

    private fun init() {
        val mButton = findViewById<Button>(R.id.button)
        mButton.setOnClickListener(this)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private fun checkPermissionAndToActivity() {
        mPermissionList.clear()
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                mPermissionList.add(permission)
            }
        }
        if (mPermissionList.isEmpty()) {
            val intent = Intent(this@MainActivity, RecyclerViewActivity::class.java)
            startActivity(intent)
        } else {
            val permissionsStringArray = mPermissionList.toTypedArray()
            ActivityCompat.requestPermissions(this@MainActivity, permissions, PERMISSION_REQUEST)
        }
    }

    companion object {
        const val PERMISSION_REQUEST = 1
    }
}