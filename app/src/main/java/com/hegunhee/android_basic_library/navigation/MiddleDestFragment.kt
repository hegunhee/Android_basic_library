package com.hegunhee.android_basic_library.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hegunhee.android_basic_library.databinding.FragmentMiddleBinding
import com.hegunhee.android_basic_library.databinding.FragmentMiddleDestBinding

class MiddleDestFragment : Fragment() {

    private lateinit var binding : FragmentMiddleDestBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMiddleDestBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            binding.textview.text = it["myArg"].toString()
        }
    }
}