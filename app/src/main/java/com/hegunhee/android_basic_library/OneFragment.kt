package com.hegunhee.android_basic_library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hegunhee.android_basic_library.databinding.FragmentOneBinding

class OneFragment : Fragment() {
    private lateinit var binding : FragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater)
        return binding.root

    }
    companion object{
        const val TAG_ONE = "one"
        fun newInstance() = OneFragment()
    }
}