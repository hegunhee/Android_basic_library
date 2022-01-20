package com.hegunhee.android_basic_library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hegunhee.android_basic_library.databinding.ActivityFragmentContainerBinding

class FragmentContainerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentContainerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentContainerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() = with(binding) {
        fragment1Button.setOnClickListener {
            showFragment(OneFragment.newInstance(), OneFragment.TAG_ONE)
        }
        fragment2Button.setOnClickListener {
            showFragment(TwoFragment.newInstance(), TwoFragment.TWO_TAG)
        }
        fragment3Button.setOnClickListener {
            showFragment(ThreeFragment.newInstance(), ThreeFragment.THREE_TAG)
        }
    }

    private fun showFragment(fragment: Fragment, tag: String) {
        val findFragment = supportFragmentManager.findFragmentByTag(tag)
        supportFragmentManager.fragments.forEach { fm ->
            supportFragmentManager.beginTransaction().hide(fm).commitAllowingStateLoss()
        }
        findFragment?.let {
            supportFragmentManager.beginTransaction().show(it).commitAllowingStateLoss()
        } ?: kotlin.run {
            supportFragmentManager.beginTransaction().add(binding.container.id, fragment, tag)
                .commitAllowingStateLoss()
        }

    }
}