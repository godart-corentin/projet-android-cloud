package com.jordroid.android_cloud_2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainButtonActivityIntent.setOnClickListener { goToActivityIntent() }
    }

    /**
     * Redirect to the new activity
     */
    private fun goToActivityIntent() {
        startActivity(Intent(this, FirstActivity::class.java))
    }
}