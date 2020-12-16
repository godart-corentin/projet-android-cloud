package com.godartcn.projetandroidcloud.repository

import androidx.lifecycle.LiveData
import com.godartcn.projetandroidcloud.architecture.CustomApplication
import com.godartcn.projetandroidcloud.architecture.RetrofitBuilder
import com.godartcn.projetandroidcloud.model.Avatar
import com.godartcn.projetandroidcloud.model.GOTCharacter
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GOTCharacterRepository {
    private val dao = CustomApplication.instance.mApplicationDatabase.mGOTCharacterDao()
    private val database = FirebaseDatabase.getInstance("https://projet-android-ea1d0-default-rtdb.europe-west1.firebasedatabase.app/")

    fun getDataFromDatabase(): LiveData<List<GOTCharacter>> {
        return dao.selectAll()
    }

    private suspend fun insert(myData: GOTCharacter) = withContext(Dispatchers.IO) {
        dao.insert(myData)
    }

    suspend fun removeAll() = withContext(Dispatchers.IO) {
        dao.deleteAll()
        database.getReference("character").setValue(null)
    }

    suspend fun fetchData(random: String) {
        val character = RetrofitBuilder.getGOTCharacter().getRandomCharacter(random)
        insert(character)
        val myRef = database.getReference("character/${random}")
        myRef.setValue(character)
    }
}