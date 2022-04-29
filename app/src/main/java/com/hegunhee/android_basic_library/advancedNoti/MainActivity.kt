package com.hegunhee.android_basic_library.advancedNoti

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.hegunhee.android_basic_library.R
import com.hegunhee.android_basic_library.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()

    }

    private fun initViews() = with(binding) {
        justNotiButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "JustNotification", Toast.LENGTH_SHORT).show()
            createJustNotificationChannel()
            createJustBuilder()
        }
        clickableNotiButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "ClickableNotification", Toast.LENGTH_SHORT).show()
            createClickableNotificationChannel()
            createClickableNotificationBuilder()
        }
        replyNotiButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "replyNotification", Toast.LENGTH_SHORT).show()
        }
    }

    private fun createJustNotificationChannel() {
        val important = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(JUST_NOTI_CHANNEL_ID, "just_noti_name", important).apply {
            description = "just_noti_desc"
        }
        (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).apply {
            createNotificationChannel(channel)
        }
    }

    private fun createJustBuilder() {
        val builder = NotificationCompat.Builder(this, JUST_NOTI_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("단순 알림입니다.")
            .setContentText("단순 그자체")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
        NotificationManagerCompat.from(this).notify(JUST_NOTI_ID, builder.build())
    }

    private fun createClickableNotificationChannel(){
        val important = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(CLICKABLE_NOTI_CHANNEL_ID,"clickable_noti_name",important).apply {
            description = "clickable_noti_desc"
        }
        (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).apply {
            createNotificationChannel(channel)
        }
    }

    private fun createClickableNotificationBuilder(){
        val pendingIntent = Intent(this,ClickActivity::class.java)?.run {
            PendingIntent.getActivity(this@MainActivity,12,this,PendingIntent.FLAG_UPDATE_CURRENT)
        }
        val builder = NotificationCompat.Builder(this, CLICKABLE_NOTI_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("클릭할 수 있는 알림입니다.")
            .setContentText("클릭 그자체")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
        NotificationManagerCompat.from(this).notify(CLICKABLE_NOTI_ID,builder.build())
    }

    companion object {
        const val JUST_NOTI_CHANNEL_ID = "JustNoti"
        const val JUST_NOTI_ID = 10
        const val CLICKABLE_NOTI_CHANNEL_ID = "ClickableNoti"
        const val CLICKABLE_NOTI_ID = 20
        const val REPLY_NOTI_CHANNEL_ID = "ReplyNoti"
        const val REPLY_NOTI_ID = 30
    }
}