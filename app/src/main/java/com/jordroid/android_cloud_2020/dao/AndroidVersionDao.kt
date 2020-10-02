package com.jordroid.android_cloud_2020.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jordroid.android_cloud_2020.model.ObjectDataSample

@Dao
interface AndroidVersionDao {

    @Query("SELECT * FROM android_version_object_table ORDER BY versionName ASC")
    fun selectAll(): LiveData<List<ObjectDataSample>>

    @Insert()
    fun insert(androidVersion: ObjectDataSample)

    @Query("DELETE FROM android_version_object_table")
    fun deleteAll()
}