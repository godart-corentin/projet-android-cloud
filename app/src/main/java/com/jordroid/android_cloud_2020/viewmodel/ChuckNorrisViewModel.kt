package com.jordroid.android_cloud_2020.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jordroid.android_cloud_2020.model.ChuckNorrisQuote
import com.jordroid.android_cloud_2020.repository.ChuckNorrisQuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChuckNorrisViewModel : ViewModel() {

    private val mChuckNorrisQuoteRepository: ChuckNorrisQuoteRepository by lazy { ChuckNorrisQuoteRepository() }
    var mChuckNorrisQuoteLiveData: LiveData<List<ChuckNorrisQuote>> = mChuckNorrisQuoteRepository.selectAllChuckNorrisQuote()

    fun fetchNewQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            mChuckNorrisQuoteRepository.fetchData()
        }
    }

    fun deleteAllQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            mChuckNorrisQuoteRepository.deleteAllChuckNorrisQuote()
        }
    }
}