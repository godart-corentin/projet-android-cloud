package com.jordroid.android_cloud_2020.repository

import androidx.lifecycle.LiveData
import com.jordroid.android_cloud_2020.architecture.CustomApplication
import com.jordroid.android_cloud_2020.architecture.RetrofitBuilder
import com.jordroid.android_cloud_2020.model.ChuckNorrisQuote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChuckNorrisQuoteRepository {

    private val mChuckNorrisDao = CustomApplication.instance.mApplicationDatabase.mChuckNorrisDao()

    fun selectAllChuckNorrisQuote() : LiveData<List<ChuckNorrisQuote>> {
        return mChuckNorrisDao.selectAll()
    }

    private suspend fun insertChuckNorrisQuote(chuckNorrisQuote: ChuckNorrisQuote) = withContext(Dispatchers.IO) {
        mChuckNorrisDao.insert(chuckNorrisQuote)
    }

    suspend fun deleteAllChuckNorrisQuote() = withContext(Dispatchers.IO) {
        mChuckNorrisDao.deleteAll()
    }

    suspend fun fetchData() {
        insertChuckNorrisQuote(RetrofitBuilder.getChuckNorrisQuote().getRandomQuote())
    }
}