package com.godartcn.projetandroidcloud.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.godartcn.projetandroidcloud.R
import com.godartcn.projetandroidcloud.model.GOTCharacter
import com.godartcn.projetandroidcloud.view.adapter.GOTCharacterAdapter
import com.godartcn.projetandroidcloud.viewmodel.GOTCharacterViewModel
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlin.random.Random

class RetrofitActivity : AppCompatActivity() {

    private lateinit var adapter: GOTCharacterAdapter
    private lateinit var viewModel: GOTCharacterViewModel
    private var observerMyData = Observer<List<GOTCharacter>>{
        updateUi(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        adapter = GOTCharacterAdapter(this)
        viewModel = ViewModelProvider(this)[GOTCharacterViewModel::class.java]
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter

        buttonAddItem.setOnClickListener {
            addRandomCharacter()
        }

        buttonDeleteItem.setOnClickListener {
            deleteData()
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.myData.observe(this, observerMyData)
    }

    override fun onStop() {
        viewModel.myData.removeObserver(observerMyData)
        super.onStop()
    }

    private fun updateUi(data : List<GOTCharacter>) {
        adapter.rebuild(data)
    }

    private fun addRandomCharacter() {
        val random = Random.nextInt(0, 1000)
        viewModel.fetchNewCharacter(random.toString())
    }

    private fun deleteData() {
        viewModel.removeAllData()
    }
}
