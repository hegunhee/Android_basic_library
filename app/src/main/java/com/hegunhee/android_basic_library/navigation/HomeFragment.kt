package com.hegunhee.android_basic_library.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hegunhee.android_basic_library.R
import com.hegunhee.android_basic_library.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() = with(binding) {
        oneButton.setOnClickListener {
            sendDataNavigation(1)
        }
        twoButton.setOnClickListener {
            sendDataNavigation(2)
        }
    }

    private fun sendDataNavigation(data: Int = 0) {
        findNavController().navigate(HomeFragmentDirections.homeToDest(data))
    }
}