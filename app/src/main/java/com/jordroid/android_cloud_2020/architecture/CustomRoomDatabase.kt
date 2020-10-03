package com.jordroid.android_cloud_2020.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jordroid.android_cloud_2020.dao.AndroidVersionDao
import com.jordroid.android_cloud_2020.dao.ChuckNorrisQuoteDao
import com.jordroid.android_cloud_2020.model.ObjectDataSample
import com.jordroid.android_cloud_2020.model.ChuckNorrisQuote

@Database(
    entities = [
        ObjectDataSample::class,
        ChuckNorrisQuote::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun mAndroidVersionDao(): AndroidVersionDao

    abstract fun mChuckNorrisDao(): ChuckNorrisQuoteDao
}
