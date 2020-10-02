package com.jordroid.android_cloud_2020.repository

import androidx.lifecycle.LiveData
import com.jordroid.android_cloud_2020.architecture.CustomApplication
import com.jordroid.android_cloud_2020.model.ObjectDataSample
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AndroidVersionRepository {

    private val mAndroidVersionDao = CustomApplication.instance.mApplicationDatabase.mAndroidVersionDao()

    fun selectAllAndroidVersion() : LiveData<List<ObjectDataSample>> {
        return mAndroidVersionDao.selectAll()
    }

    suspend fun insertAndroidVersion(objectDataSample: ObjectDataSample) = withContext(Dispatchers.IO) {
        mAndroidVersionDao.insert(objectDataSample)
    }

    suspend fun deleteAllAndroidVersion() = withContext(Dispatchers.IO) {
        mAndroidVersionDao.deleteAll()
    }
}