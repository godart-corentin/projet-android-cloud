package com.jordroid.android_cloud_2020.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "android_version_object_table")
data class ObjectDataSample(
    val versionName : String,
    val versionCode : Int,
    val versionImage : String
) {
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0
}