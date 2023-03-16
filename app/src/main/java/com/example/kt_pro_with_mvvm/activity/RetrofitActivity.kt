package com.example.kt_pro_with_mvvm.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kt_pro_with_mvvm.R
import com.example.kt_pro_with_mvvm.databinding.ActivityRetrofitBinding
import com.example.kt_pro_with_mvvm.models.FeatchSimpleData
import com.example.kt_pro_with_mvvm.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

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


                    }


//                    binding.tv.text = response.message()
                }

                override fun onFailure(call: Call<FeatchSimpleData?>, t: Throwable) {
                    Log.e("Retrofit_onFailure", "" + t.toString())

                    TODO("Not yet implemented")
                    Toast.makeText(
                        this@RetrofitActivity,
                        "${t.localizedMessage}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }
}


