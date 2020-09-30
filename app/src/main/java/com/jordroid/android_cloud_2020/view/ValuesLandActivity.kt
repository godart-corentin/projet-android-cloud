package com.jordroid.android_cloud_2020.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jordroid.android_cloud_2020.R
import kotlinx.android.synthetic.main.activity_values_configuration.*

class ValuesLandActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_values_configuration)

        switchValuesLand.text = getString(R.string.random_string)
        switchValuesLand.isEnabled = resources.getBoolean(R.bool.flag)
    }
}