package com.hegunhee.android_basic_library.advancedNoti

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.app.RemoteInput
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hegunhee.android_basic_library.advancedNoti.db.LogDao
import com.hegunhee.android_basic_library.advancedNoti.db.LogData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class MyReceiver : BroadcastReceiver() {

    @Inject
    lateinit var logDao: LogDao
    override fun onReceive(context: Context, intent: Intent) {
        val replyText = RemoteInput.getResultsFromIntent(intent)
            ?.getCharSequence(MainActivity.KEY_TEXT_REPLY).toString()

        saveData(context, replyText)
        (context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).cancel(
            MainActivity.REPLY_NOTI_ID
        )
    }

    @SuppressLint("SimpleDateFormat")
    private fun saveData(context: Context, text: String) {
        val time: String = LocalDateTime.now().plusHours(9)
            .run { this.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초")) }
        val data = LogData(text, time)
        Toast.makeText(context, data.toString(), Toast.LENGTH_SHORT).show()
        GlobalScope.launch(Dispatchers.IO) {
            logDao.insert(data)
        }
    }
}