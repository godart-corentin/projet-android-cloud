package com.jordroid.android_cloud_2020.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jordroid.android_cloud_2020.R
import com.jordroid.android_cloud_2020.model.ChuckNorrisQuote
import com.jordroid.android_cloud_2020.view.adapter.ChuckNorrisQuoteAdapter
import com.jordroid.android_cloud_2020.viewmodel.ChuckNorrisViewModel
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlin.collections.ArrayList

class RecyclerViewActivity : AppCompatActivity() {

    // We need variable of our adapter
    private lateinit var mAdapter: ChuckNorrisQuoteAdapter
    private lateinit var mViewModel: ChuckNorrisViewModel
    private var mObserverAndroidVersion = Observer<List<ChuckNorrisQuote>> {
        updateRecyclerView(ArrayList(it))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        mViewModel = ViewModelProvider(this)[ChuckNorrisViewModel::class.java]
        // Create the instance of adapter
        mAdapter = ChuckNorrisQuoteAdapter(this)
        // We define the style
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        // We set the adapter to recycler view
        recyclerView.adapter = mAdapter

        buttonAddItem.setOnClickListener { addRandomAndroidVersion() }
        buttonDeleteItem.setOnClickListener { deleteAndroidVersion() }
    }

    override fun onStart() {
        super.onStart()
        mViewModel.mChuckNorrisQuoteLiveData.observe(this, mObserverAndroidVersion)
    }

    override fun onStop() {
        mViewModel.mChuckNorrisQuoteLiveData.removeObserver(mObserverAndroidVersion)
        super.onStop()
    }

    private fun updateRecyclerView(newList: ArrayList<ChuckNorrisQuote>) {
        mAdapter.rebuild(newList)
    }

    private fun addRandomAndroidVersion() {
        mViewModel.fetchNewQuote()
    }

    private fun deleteAndroidVersion() {
        mViewModel.deleteAllQuote()
    }
}
