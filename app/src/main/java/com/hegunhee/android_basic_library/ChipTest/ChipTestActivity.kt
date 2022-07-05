package com.hegunhee.android_basic_library.ChipTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hegunhee.android_basic_library.R
import com.hegunhee.android_basic_library.databinding.ActivityChipTestBinding

class ChipTestActivity : AppCompatActivity() {

    private val binding : ActivityChipTestBinding by lazy {ActivityChipTestBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initListener()
    }

    private fun initListener() = with(binding){
//        singleChip.setOnClickListener {
//            Toast.makeText(this@ChipTestActivity, "chip click", Toast.LENGTH_SHORT).show()
//        }
        singleChip.setOnCloseIconClickListener {
            Toast.makeText(this@ChipTestActivity, "뭐지", Toast.LENGTH_SHORT).show()
        }
    }
}