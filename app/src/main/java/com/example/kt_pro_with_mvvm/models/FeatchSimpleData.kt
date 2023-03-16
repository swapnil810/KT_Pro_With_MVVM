package com.example.kt_pro_with_mvvm.models

//https://reqres.in/api/unknown
data class FeatchSimpleData(
    val `data`: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)