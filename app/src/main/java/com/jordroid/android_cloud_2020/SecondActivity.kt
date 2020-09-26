package com.jordroid.android_cloud_2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jordroid.android_cloud_2020.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get the xml layout to attach to this activity
        setContentView(R.layout.activity_second)

        val valueFromIntent = intent?.extras?.getString("MY_KEY")
        secondActivityText.text = valueFromIntent
    }
}