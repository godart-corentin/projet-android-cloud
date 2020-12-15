package com.godartcn.projetandroidcloud.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.godartcn.projetandroidcloud.R
import com.godartcn.projetandroidcloud.interfaces.OnClickCallback
import com.godartcn.projetandroidcloud.model.Avatar
import com.godartcn.projetandroidcloud.view.adapter.ImageAdapter
import com.godartcn.projetandroidcloud.viewmodel.AvatarViewModel
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlin.random.Random

class RecyclerViewActivity : AppCompatActivity(), OnClickCallback {

    private lateinit var adapter: ImageAdapter
    private lateinit var viewModel: AvatarViewModel
    private var observerMyData = Observer<List<Avatar>>{
        updateUi(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        adapter = ImageAdapter(this)
        viewModel = ViewModelProvider(this)[AvatarViewModel::class.java]
        recyclerView.layoutManager = GridLayoutManager(this,resources.getInteger(R.integer.number_of_columns))
        recyclerView.adapter = adapter

        buttonAddItem.setOnClickListener {
            addValue()
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

    private fun updateUi(data : List<Avatar>) {
        adapter.rebuild(data)
    }

    private fun addValue() {
        val random = Random.nextInt(0, 1000)
        viewModel.insertData("https://picsum.photos/id/$random/200", "ID: $random")
    }

    private fun deleteData() {
        viewModel.removeAllData()
    }

    override fun onItemClick(avatar: Avatar) {
        viewModel.removeData(avatar)
    }
}
