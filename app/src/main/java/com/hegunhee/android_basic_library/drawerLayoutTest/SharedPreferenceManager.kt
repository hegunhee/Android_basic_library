package com.hegunhee.android_basic_library.drawerLayoutTest

import android.content.Context

class SharedPreferenceManager private constructor(context : Context) {

    private val prefs = context.getSharedPreferences(PRES_NAME,Context.MODE_PRIVATE)

    fun getStr() : String{
        return prefs.getString(KEY,DEFAULT_VALUE).toString()
    }

    fun setStr(value : String){
        prefs.edit().putString(KEY,value).apply()
    }


    companion object{
        const val PRES_NAME = "pref_name"
        const val KEY = "key"
        const val DEFAULT_VALUE = "defualt"

        private var instance : SharedPreferenceManager? = null
        fun getInstance(context : Context) : SharedPreferenceManager{
            if(instance == null){
                instance = SharedPreferenceManager(context)
            }
            return instance!!
        }
    }
}