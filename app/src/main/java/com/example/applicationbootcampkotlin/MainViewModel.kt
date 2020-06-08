package com.example.applicationbootcampkotlin

import android.util.MutableDouble
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    var item = MutableLiveData<String>()

    init {
        item.value = null
    }

    fun showMsg(){
        item.value = "this is message"
    }
}