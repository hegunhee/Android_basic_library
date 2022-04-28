package com.hegunhee.android_basic_library.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import com.hegunhee.android_basic_library.R
import com.hegunhee.android_basic_library.databinding.ActivityActionViewBinding

class ActionViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityActionViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActionViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.action_menu, menu)
        val menuItem = menu?.findItem(R.id.menu_search)
        val searchView = menuItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                binding.textView.text = p0+ "검색"
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                binding.textView.text = p0
                return true
            }


        })
        return true
    }
}