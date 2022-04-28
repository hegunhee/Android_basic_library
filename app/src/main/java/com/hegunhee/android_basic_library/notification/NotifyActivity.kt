package com.hegunhee.android_basic_library.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import com.hegunhee.android_basic_library.R
import com.hegunhee.android_basic_library.databinding.ActivityNotifyBinding

class NotifyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNotifyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.notificationButton.setOnClickListener {
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val builder: NotificationCompat.Builder
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channelId = "one-channel"
                val channelName = "My Channel One"
                val channel = NotificationChannel(
                    channelId,
                    channelName,
                    NotificationManager.IMPORTANCE_DEFAULT
                ).apply {
                    description = "My Channel One Description"
                    setShowBadge(true)
                    val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                    val audioAttributes = AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .setUsage(AudioAttributes.USAGE_ALARM)
                        .build()
                    setSound(uri, audioAttributes)
                    enableVibration(true)
                }
                manager.createNotificationChannel(channel)
                builder = NotificationCompat.Builder(this, channelId)

            } else {
                builder = NotificationCompat.Builder(this)
            }
            builder.run {
                setSmallIcon(R.drawable.ic_launcher_foreground)
                setWhen(System.currentTimeMillis())
                setContentTitle("홍길동")
                setContentText("안녕하세요")
            }
            val KEY_TEXT_REPLY = "key_text_reply"
            val replyLabel: String = "답장"
            val remoteInput = RemoteInput.Builder(KEY_TEXT_REPLY).run {
                setLabel(replyLabel)
                build()
            }
            val replyIntent = Intent(this, NotifyReceiver::class.java)
            val replyPendingIntent = PendingIntent.getBroadcast(
                this, 30, replyIntent, PendingIntent.FLAG_UPDATE_CURRENT
            )
            builder.addAction(
                NotificationCompat.Action.Builder(
                    R.drawable.ic_launcher_background,
                    "답장",
                    replyPendingIntent

                ).addRemoteInput(remoteInput).build()
            )
            manager.notify(11,builder.build())

        }
    }
}