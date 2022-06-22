package com.hegunhee.android_basic_library.drawerLayoutTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.hegunhee.android_basic_library.R
import com.hegunhee.android_basic_library.databinding.ActivityDrawerLayoutMainBinding

class DrawerLayoutMainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDrawerLayoutMainBinding
    private lateinit var toolBar : Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawerLayoutMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolBar = binding.toolBar
        setSupportActionBar(toolBar)
        setNavigation()
    }
    private fun setNavigation() = with(binding){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController
        navView.setupWithNavController(navController)
    }
}