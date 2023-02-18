package com.example.kt_pro_with_mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val quoteLiveData = MutableLiveData("mutable live data what is done or what is not done")
    fun updateQuote(){
        quoteLiveData.value = "updateQuate method"
    }

}