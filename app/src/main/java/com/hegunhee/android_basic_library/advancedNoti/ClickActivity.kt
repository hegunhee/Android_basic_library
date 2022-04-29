package com.hegunhee.android_basic_library.advancedNoti

import android.app.NotificationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hegunhee.android_basic_library.R
import com.hegunhee.android_basic_library.databinding.ActivityClickBinding

class ClickActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClickBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClickBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (this.getSystemService(NOTIFICATION_SERVICE) as NotificationManager).cancel(
            MainActivity.CLICKABLE_NOTI_ID
        )
    }
}