package com.hegunhee.android_basic_library.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hegunhee.android_basic_library.R
import com.hegunhee.android_basic_library.databinding.FragmentMiddleBinding

class MiddleFragment : Fragment(){

    private lateinit var binding : FragmentMiddleBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMiddleBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() = with(binding){
        button.setOnClickListener {
            if(editText.text.toString() == ""){
                Toast.makeText(requireContext(), "값을입력해주세요", Toast.LENGTH_SHORT).show()
            }else{
                bundleOf("myArg" to editText.text.toString()).run {
                    findNavController().navigate(R.id.middle_to_dest,this)
                }
            }
        }

    }
}