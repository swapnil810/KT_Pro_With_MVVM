package com.example.kt_pro_with_mvvm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.kt_pro_with_mvvm.R
import com.example.kt_pro_with_mvvm.databinding.ActivityHomeBinding
import com.example.kt_pro_with_mvvm.fm.FirstFragment
import com.example.kt_pro_with_mvvm.fm.MvvmFragment
import com.example.kt_pro_with_mvvm.fm.ScrollingFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var homeActivityBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        homeActivityBinding.lifecycleOwner = this

        var emails = intent.getStringExtra("email")
        var passw = intent.getStringExtra("pass")

        Toast.makeText(applicationContext, "email_id : $emails", Toast.LENGTH_SHORT).show()
        Toast.makeText(applicationContext, "passw : $passw", Toast.LENGTH_SHORT).show()


        loadFragment(FirstFragment(emails,passw))

        homeActivityBinding.bottomNavigationView.setOnItemSelectedListener {

            val fragment = when (it.itemId) {
                R.id.firstFragment -> {
                    FirstFragment(emails,passw)
                }
                R.id.secondFragment -> {
                    MvvmFragment()
                }
                R.id.thirdFragment -> {
                    ScrollingFragment()
                }
                else -> {
                    FirstFragment(emails,passw)
                }
            }
            loadFragment(fragment)
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}