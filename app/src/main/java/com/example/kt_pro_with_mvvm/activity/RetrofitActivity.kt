package com.example.kt_pro_with_mvvm.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kt_pro_with_mvvm.R
import com.example.kt_pro_with_mvvm.databinding.ActivityRetrofitBinding
import com.example.kt_pro_with_mvvm.models.Data
import com.example.kt_pro_with_mvvm.models.FeatchSimpleData
import com.example.kt_pro_with_mvvm.network.RetrofitInstance
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Response


class RetrofitActivity : AppCompatActivity() {
    lateinit var binding: ActivityRetrofitBinding
    var list: ArrayList<FeatchSimpleData> = arrayListOf<FeatchSimpleData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofitBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_retrofit)
        getData()
    }

    private fun getData() {
        RetrofitInstance.apiInterface.getData()
            .enqueue(object : retrofit2.Callback<FeatchSimpleData?> {
                override fun onResponse(
                    call: Call<FeatchSimpleData?>,
                    response: Response<FeatchSimpleData?>
                ) {
                    Log.e("Retrofit_onResponse", "" + response.toString())
                    if (response.isSuccessful()) {
// First  way
//                        val fetchSimpalData: FeatchSimpleData? = response.body()
//                        val totalCnt: String = response.body()!!.total.toString()
//                        val totalPge: String = response.body()!!.total_pages.toString()
//                        val name: String = response.body()!!.data.get(1).name
//                        Toast.makeText(this@RetrofitActivity, "API $name", Toast.LENGTH_SHORT).show()
//                        binding.tv.text = name
// Second way

                        val userList: FeatchSimpleData? = response.body()
                        val text: String = userList?.total.toString()
                        val total: String = userList?.per_page.toString()
                        val totalPages: Int = userList?.total_pages ?: 0
                        val datumList: List<Data> = (userList?.data ?: Toast.makeText(
                            applicationContext,
                            "$text page\n$total total\n$totalPages totalPages\n", Toast.LENGTH_SHORT
                        ).show()) as List<Data>

                        for (datum in datumList) {
                            Toast.makeText(
                                applicationContext,
                                "id : " + datum.id + " name: " + datum.name + "color " + datum.color + " year: " + datum.year,
                                Toast.LENGTH_SHORT
                            ).show()
                        }

//                        Log.e("Success", Gson().toJson(response.body()))
//                        Log.e("Retrofit_Response_Body", "" + response.body().toString())


                    }

                }

                override fun onFailure(call: Call<FeatchSimpleData?>, t: Throwable) {
                    Log.e("Retrofit_onFailure", "" + t.toString())
                    Toast.makeText(this@RetrofitActivity, "${t.localizedMessage}", Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }
}


