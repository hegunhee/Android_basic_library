package com.hegunhee.android_basic_library.drawerLayoutTest

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.hegunhee.android_basic_library.R

class SharedPreferenceFragment : Fragment() {

    private val prefs : SharedPreferenceManager by lazy { SharedPreferenceManager.getInstance(requireContext()) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sharedpreference,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.shared_textView).text = prefs.getStr()

        view.findViewById<Button>(R.id.shared_button).setOnClickListener {
            val text = view.findViewById<EditText>(R.id.shared_editText).text.toString()
            if(text != ""){
                prefs.setStr(text)
                view.findViewById<TextView>(R.id.shared_textView).text = prefs.getStr()
            }
        }


    }
}