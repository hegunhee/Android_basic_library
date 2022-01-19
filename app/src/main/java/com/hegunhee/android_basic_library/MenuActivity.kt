package com.hegunhee.android_basic_library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.title) {
        "menu1"-> {
            Log.d("tag", "0")
            true
        }
        "menu2" -> {
            Log.d("tag", "1")
            true
        }
        "menu3" -> {
            Log.d("tag", "1")
            true
        }
        else -> {
            false
        }
    }
}