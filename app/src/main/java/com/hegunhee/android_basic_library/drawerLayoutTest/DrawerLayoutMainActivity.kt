package com.hegunhee.android_basic_library.drawerLayoutTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.hegunhee.android_basic_library.R
import com.hegunhee.android_basic_library.databinding.ActivityDrawerLayoutMainBinding

class DrawerLayoutMainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDrawerLayoutMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawerLayoutMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setNavigation()
    }
    private fun setNavigation() = with(binding){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController
        navView.setupWithNavController(navController)
    }
}