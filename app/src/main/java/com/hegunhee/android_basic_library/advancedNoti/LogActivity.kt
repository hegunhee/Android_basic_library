package com.hegunhee.android_basic_library.advancedNoti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hegunhee.android_basic_library.advancedNoti.db.LogDao
import com.hegunhee.android_basic_library.advancedNoti.db.LogData
import com.hegunhee.android_basic_library.databinding.ActivityLogBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LogActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLogBinding
    @Inject lateinit var logDao : LogDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        GlobalScope.launch(Dispatchers.IO) {
            Log.d("logData",logDao.getAll().toString())
        }
    }
}