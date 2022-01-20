package com.hegunhee.android_basic_library

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hegunhee.android_basic_library.databinding.FragmentThreeBinding

class ThreeFragment : Fragment() {
    private lateinit var binding : FragmentThreeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentThreeBinding.inflate(inflater)
        return binding.root
    }

    companion object{
        const val THREE_TAG = "three"
        fun newInstance() = ThreeFragment()
    }
}