package com.example.kt_pro_with_mvvm.network

import com.example.kt_pro_with_mvvm.models.FeatchSimpleData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("unknown")
    fun getData(): Call<FeatchSimpleData>

    //https://reqres.in/
    //https://reqres.in/api/users?page=2
    @GET("https://reqres.in/api/unknown")
    fun getDataPage(): Call<FeatchSimpleData>
}