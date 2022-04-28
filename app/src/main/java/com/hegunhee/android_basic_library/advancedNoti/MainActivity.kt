package com.hegunhee.android_basic_library.advancedNoti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hegunhee.android_basic_library.R
import com.hegunhee.android_basic_library.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()

    }
    private fun initViews() = with(binding){
        justNotiButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "JustNotification", Toast.LENGTH_SHORT).show()
        }
        clickableNotiButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "ClickableNotification", Toast.LENGTH_SHORT).show()
        }
        replyNotiButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "replyNotification", Toast.LENGTH_SHORT).show()
        }
    }
}