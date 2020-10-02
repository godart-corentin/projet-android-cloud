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
            ObjectDataSample(
                "Android Lollipop",
                5,
                "https://lh3.googleusercontent.com/-rACz0MZcC3g/VcUIM6IJr5I/AAAAAAAAAB4/bnKPAnrGL1A/s400/Google-officially-released-Android-5.0-Lollipop-source-code-into-the-AOSP-Details.png"
            ),
            ObjectDataSample(
                "Android Marshmallow",
                6,
                "https://www.android-logiciels.fr/wp-content/uploads/2015/08/android-m-news.png"
            ),
            ObjectDataSample(
                "Android Nougat",
                7,
                "https://img-0.journaldunet.com/9K_wGeBu2TxODL6zOEHZWgsacKE=/1240x/smart/af8490af57424d3e923a0259002a111b/ccmcms-jdn/10336314-android-7-0-nougat-les-nouveautes-a-retenir.jpg"
            ),
            ObjectDataSample(
                "Android Oreo",
                8,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Android_Oreo_8.1_logo.svg/1200px-Android_Oreo_8.1_logo.svg.png"
            ),
            ObjectDataSample(
                "Android Pie",
                9,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/13/Android_P_logo.svg/1200px-Android_P_logo.svg.png"
            ),
            ObjectDataSample(
                "Android Q",
                10,
                "https://images.frandroid.com/wp-content/uploads/2018/05/android-q-developer-preview-logo.jpg"
            )
        )
    }
}
