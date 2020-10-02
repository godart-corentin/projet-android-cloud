package com.jordroid.android_cloud_2020.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jordroid.android_cloud_2020.R
import com.jordroid.android_cloud_2020.model.ObjectDataSample
import com.jordroid.android_cloud_2020.viewmodel.AndroidVersionViewModel
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class RecyclerViewActivity : AppCompatActivity() {

    // We need variable of our adapter
    private lateinit var mAdapter: AndroidVersionAdapter
    private lateinit var mViewModel: AndroidVersionViewModel
    private var mObserverAndroidVersion = Observer<List<ObjectDataSample>> {
        updateRecyclerView(ArrayList(it))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        mViewModel = ViewModelProvider(this)[AndroidVersionViewModel::class.java]
        // Create the instance of adapter
        mAdapter = AndroidVersionAdapter(this)
        // We define the style
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        // We set the adapter to recycler view
        recyclerView.adapter = mAdapter

        buttonAddItem.setOnClickListener { addRandomAndroidVersion() }
        buttonDeleteItem.setOnClickListener { deleteAndroidVersion() }
    }

    override fun onStart() {
        super.onStart()
        mViewModel.mAndroidVersionLiveData.observe(this, mObserverAndroidVersion)
    }

    override fun onStop() {
        mViewModel.mAndroidVersionLiveData.removeObserver(mObserverAndroidVersion)
        super.onStop()
    }

    private fun updateRecyclerView(newList: ArrayList<ObjectDataSample>) {
        mAdapter.rebuild(newList)
    }

    private fun addRandomAndroidVersion() {
        val random = Random.nextInt(0, 1000)
        mViewModel.insertAndroidVersion("Android $random", random, "url:$random")
    }

    private fun deleteAndroidVersion() {
        mViewModel.deleteAllAndroidVersion()
    }
}
