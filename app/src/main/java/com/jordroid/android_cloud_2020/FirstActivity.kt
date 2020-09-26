package com.jordroid.android_cloud_2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get the xml layout to attach to this activity
        setContentView(R.layout.activity_first)

        // We can get the TextView directly from it's id and interact with it
        firstActivityTextViewTitle.text = "Another text from activity"
        firstActivityButton.setOnClickListener {
            generateIntentAndGoTo()
        }
    }

    private fun generateIntentAndGoTo() {
        // Java style
        val intent = Intent(this, SecondActivity::class.java)
        val bundle = Bundle()
        bundle.putString("MY_KEY", "MY_VALUE")
        intent.putExtras(bundle)
        // Start activity
        startActivity(intent)


        // Kotlin style
        /*val intentKotlin = Intent(this, SecondActivity::class.java).also {
            it.putExtras(Bundle().apply {
                putString("MY_KEY", "MY_VALUE")
            })
        }
        // Start activity
        startActivity(intentKotlin)*/
    }
}