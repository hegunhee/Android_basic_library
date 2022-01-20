package com.hegunhee.android_basic_library

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hegunhee.android_basic_library.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {

    private lateinit var binding : FragmentTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTwoBinding.inflate(inflater)
        return binding.root

    }
    companion object{
        const val TWO_TAG = "two"
        fun newInstance() = TwoFragment()
    }

}