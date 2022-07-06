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
        button.setOnClickListener {
            Toast.makeText(this@ChipTestActivity, chipGroup.checkedChipIds.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}