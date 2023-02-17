package com.example.kt_pro_with_mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val quoteLiveData = MutableLiveData("swapnil_hhhh")

    fun updateQuote(){
        quoteLiveData.value = "harshu"
    }

}