package com.godartcn.projetandroidcloud.repository

import androidx.lifecycle.LiveData
import com.godartcn.projetandroidcloud.architecture.CustomApplication
import com.godartcn.projetandroidcloud.architecture.RetrofitBuilder
import com.godartcn.projetandroidcloud.model.Avatar
import com.godartcn.projetandroidcloud.model.GOTCharacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GOTCharacterRepository {
    private val dao = CustomApplication.instance.mApplicationDatabase.mGOTCharacterDao()

    fun getDataFromDatabase(): LiveData<List<GOTCharacter>> {
        return dao.selectAll()
    }

    private suspend fun insert(myData: GOTCharacter) = withContext(Dispatchers.IO) {
        dao.insert(myData)
    }

    suspend fun removeAll() = withContext(Dispatchers.IO) {
        dao.deleteAll()
    }

    suspend fun fetchData(random: String) {
        insert(RetrofitBuilder.getGOTCharacter().getRandomCharacter(random))
    }

}