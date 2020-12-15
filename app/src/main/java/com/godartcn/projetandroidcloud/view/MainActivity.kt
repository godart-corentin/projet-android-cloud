package com.godartcn.projetandroidcloud.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.godartcn.projetandroidcloud.R
import com.godartcn.projetandroidcloud.firebase.view.FirebaseLoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnListActivity.setOnClickListener { goToListActivity() }
        btnRetrofitActivity.setOnClickListener { goToRetrofitActivity() }
        btnFirebaseActivity.setOnClickListener { goToFirebaseActivity() }
    }

    private fun goToListActivity() {
        startActivity(Intent(this, RecyclerViewActivity::class.java))
    }

    private fun goToRetrofitActivity() {
        startActivity(Intent(this, RetrofitActivity::class.java))
    }

    private fun goToFirebaseActivity() {
        startActivity(Intent(this, FirebaseLoginActivity::class.java))
    }
}