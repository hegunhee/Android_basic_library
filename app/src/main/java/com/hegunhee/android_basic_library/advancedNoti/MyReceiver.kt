package com.hegunhee.android_basic_library.advancedNoti

import android.app.NotificationManager
import android.app.RemoteInput
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val replyText = RemoteInput.getResultsFromIntent(intent)
            ?.getCharSequence(MainActivity.KEY_TEXT_REPLY)
        Toast.makeText(context, replyText?.toString(), Toast.LENGTH_SHORT).show()
        (context.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager).cancel(
            MainActivity.REPLY_NOTI_ID
        )
    }
}