package com.example.kt_pro_with_mvvm.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.kt_pro_with_mvvm.R
import com.example.kt_pro_with_mvvm.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    lateinit var logInBinding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logInBinding = DataBindingUtil.setContentView(this, R.layout.activity_log_in)
        logInBinding.lifecycleOwner = this
        logInBinding.inputFirst.setText("").toString()
        logInBinding.inputSec.setText("").toString()
        clickFunction()
        location()
    }

    private fun location() {
        logInBinding.getCurrentLocation.setOnClickListener {
            val intent = Intent(this, CurrentLocationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun clickFunction() {
        logInBinding.appCompatButton2.setOnClickListener {
            val user_name = logInBinding.inputFirst.text
            val password = logInBinding.inputSec.text
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("email", user_name.toString())
            intent.putExtra("pass", password.toString())
            startActivity(intent)
        }
    }


}