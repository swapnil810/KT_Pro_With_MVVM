package com.example.kt_pro_with_mvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.kt_pro_with_mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.lifecycleOwner = this
//*****************************1st way for click*********************************************************//

        mainViewModel.quoteLiveData.observe(this, Observer {
            binding.setValueText.text = it
        })
// simple btn click using @id in xml  android:id="@+id/nextBtn"
        binding.nextBtn.setOnClickListener {
            mainViewModel.updateQuote()
        }

// ****************************2nd way for click*********************************************************//

        // mainViewModel xml mai data variable kaa name hai (yaha pe btn click pe method ko call krwa kr data update kr rhe hai)
//        binding.mainViewModel = mainViewModel
        // one way binding k liye @{} use krna padta hai android:text="@{mainViewModel.quoteLiveData}"
        // jab ki two way binding k @={} use hota hai (yaha pe textview pe data set kr rahe hai)

//***************************Simple-one-activity-to-2nd-activity-click-in-Kotlin************************//

//       click  android:id="@+id/nextBtn"
//        binding.nextBtn.setOnClickListener {
//            intent = Intent(applicationContext, BuntyActivity::class.java)
//            startActivity(intent)
//         }
    }

}