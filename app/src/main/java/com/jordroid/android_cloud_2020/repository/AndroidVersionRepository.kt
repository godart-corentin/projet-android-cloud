package com.jordroid.android_cloud_2020.repository

import com.jordroid.android_cloud_2020.model.ObjectDataSample

class AndroidVersionRepository {

    fun generateFakeData(): ArrayList<ObjectDataSample> {
        return arrayListOf(
            ObjectDataSample("Android Lollipop", 5, "url"),
            ObjectDataSample("Android Marshmallow", 6, "url"),
            ObjectDataSample("Android Nougat", 7, "url"),
            ObjectDataSample("Android Oreo", 8, "url"),
            ObjectDataSample("Android Pie", 9, "url"),
            ObjectDataSample("Android Q", 10, "url")
        )
    }
}