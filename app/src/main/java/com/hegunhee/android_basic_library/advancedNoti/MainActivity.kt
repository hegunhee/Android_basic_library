package com.hegunhee.android_basic_library.advancedNoti

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
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
            createNotificationChannel()
            createBuilder()
        }
        clickableNotiButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "ClickableNotification", Toast.LENGTH_SHORT).show()
        }
        replyNotiButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "replyNotification", Toast.LENGTH_SHORT).show()
        }
    }

    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val important = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(JUST_NOTI_ID, JUST_NOTI_NAME,important).apply {
                description = JUST_NOTI_DESC
            }
            (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).apply { createNotificationChannel(channel) }
        }
    }

    private fun createBuilder(){
        val builder = NotificationCompat.Builder(this, JUST_NOTI_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Just Notification")
            .setContentText("Just")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
        NotificationManagerCompat.from(this).notify(JUST_NOTI_NOTI_ID,builder.build())
    }

    companion object{
        const val JUST_NOTI_ID = "10"
        const val JUST_NOTI_NAME = "just_noti_name"
        const val JUST_NOTI_DESC = "just_noti_title"
        const val JUST_NOTI_NOTI_ID = 10
    }
}