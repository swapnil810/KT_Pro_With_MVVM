package com.example.kt_pro_with_mvvm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.kt_pro_with_mvvm.R
import com.example.kt_pro_with_mvvm.databinding.ActivitySeekBarBinding

class SeekBarActivity : AppCompatActivity() {

    lateinit var seekBarBinding: ActivitySeekBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        seekBarBinding = DataBindingUtil.setContentView(this, R.layout.activity_seek_bar)

        seekBarBinding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
                Toast.makeText(this@SeekBarActivity, "Progress is: " + seek.progress + "%", Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}