package com.jordroid.android_cloud_2020.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jordroid.android_cloud_2020.R
import com.jordroid.android_cloud_2020.model.ObjectDataSample
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    /**
     * Attribute
     */

    // We need variable of our adapter
    private lateinit var mAdapter: AndroidVersionAdapter

    /**
     * Manage lifecycle
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        // Create the instance of adapter
        mAdapter = AndroidVersionAdapter(this)

        // Create the instance of adapter
        mAdapter = AndroidVersionAdapter(this)
        // We define the style
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // We set the adapter to recycler view
        recyclerView.adapter = mAdapter

        // Generate data and give it to adapter
        mAdapter.rebuild(generateFakeData())
    }

    /**
     * Private method
     */

    private fun generateFakeData(): ArrayList<ObjectDataSample> {
        return arrayListOf(
            ObjectDataSample("Android Lollipop", 5),
            ObjectDataSample("Android Marshmallow", 6),
            ObjectDataSample("Android Nougat", 7),
            ObjectDataSample("Android Oreo", 8),
            ObjectDataSample("Android Pie", 9),
            ObjectDataSample("Android-Q", 10)
        )
    }
}
