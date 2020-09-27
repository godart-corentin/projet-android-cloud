package com.jordroid.android_cloud_2020.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.jordroid.android_cloud_2020.R
import kotlinx.android.synthetic.main.activity_resource.*

class ResourceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        resourceIntegerText.text = resources.getInteger(R.integer.number_of_columns).toString()
        resourceBooleanText.text = resources.getBoolean(R.bool.flag).toString()
        resourceStringText.text = resources.getString(R.string.random_string)
        resourceStringText.setBackgroundColor(ContextCompat.getColor(this, R.color.background_of_something))
    }
}