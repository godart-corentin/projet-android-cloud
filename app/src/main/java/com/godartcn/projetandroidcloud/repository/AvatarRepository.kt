package com.godartcn.projetandroidcloud.repository

import androidx.lifecycle.LiveData
import com.godartcn.projetandroidcloud.architecture.CustomApplication
import com.godartcn.projetandroidcloud.model.Avatar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AvatarRepository {
    private val dao = CustomApplication.instance.mApplicationDatabase.mAvatarDao()

    fun getDataFromDatabase(): LiveData<List<Avatar>> {
        return dao.selectAll()
    }

    suspend fun insert(myData: Avatar) = withContext(Dispatchers.IO) {
        dao.insertWithTimestamp(myData)
    }

    suspend fun removeAll() = withContext(Dispatchers.IO) {
        dao.deleteAll()
    }

    suspend fun removeOne(id: Long?) = withContext(Dispatchers.IO) {
        dao.deleteOne(id)
    }

    fun generateFakeData(): ArrayList<Avatar> {
        return arrayListOf()
    }
}