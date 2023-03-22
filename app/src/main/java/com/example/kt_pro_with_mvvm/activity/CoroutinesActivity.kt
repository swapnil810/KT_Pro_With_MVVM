package com.example.kt_pro_with_mvvm.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.kt_pro_with_mvvm.R
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class CoroutinesActivity : AppCompatActivity() {
    lateinit var counterText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_couroutins)
        counterText = findViewById(R.id.counter)
        Log.d("CoroutinesActivity", Thread.currentThread().name)
        //Dispatchers.IO //Dispatchers.Main //Dispatchers.Default
    }

    //Counter increment
    fun updateCounter(view: View) {
        Log.d("CoroutinesActivity", Thread.currentThread().name)
        counterText.text = "${counterText.text.toString().toInt() + 1}"
    }

    private fun executeLongRunningTask() {
        for (i in 1..100000000L) {
        }
    }

    //Example Using simple java thread
//    fun doAction(view: View) {
//        //Bag thread   limited quantity mai bana sktai hai 2mb space laita hai limited data
//        thread(start = true) {
//            executeLongRunningTask()
//        }
//    }

    //Example Using courtin thread
    fun doAction(view: View) {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("CoroutineScope", Thread.currentThread().name)
            executeLongRunningTask()
        }
        GlobalScope.launch(Dispatchers.Main) {
            Log.d("GlobalScope", Thread.currentThread().name)
        }
        MainScope().launch(Dispatchers.Default) {
            Log.d("MainScope", Thread.currentThread().name)
        }
    }

    //coroutine Scope life time define krta hai
    //coroutine context  kon se thread mai corutin execute hoga
    //disptchres define kis type kaa thread pool

}