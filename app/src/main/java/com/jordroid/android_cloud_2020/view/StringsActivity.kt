package com.jordroid.android_cloud_2020.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jordroid.android_cloud_2020.R
import kotlinx.android.synthetic.main.activity_strings.*

class StringsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_strings)

        textViewPluralsOne.text = resources.getQuantityString(R.plurals.found_word, 1)
        textViewPluralsTwo.text = resources.getQuantityString(R.plurals.found_word, 3)

        // Define value for dynamic content in string
        textViewDynamicString.text = String.format(getString(R.string.dynamic_content), "Serreau", "Jordane", 27);

        // You can mix dynamic values and plurals / single variable
        textViewDynamicPlurals.text = resources.getQuantityString(R.plurals.dynamic_plurals, 4, 2);
    }
}