package com.jordroid.android_cloud_2020.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jordroid.android_cloud_2020.model.ObjectDataSample
import com.jordroid.android_cloud_2020.repository.AndroidVersionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AndroidVersionViewModel : ViewModel() {

    private val mAndroidVersionRepository: AndroidVersionRepository by lazy { AndroidVersionRepository() }
    var mAndroidVersionLiveData: LiveData<List<ObjectDataSample>> = mAndroidVersionRepository.selectAllAndroidVersion()

    fun insertAndroidVersion(androidName: String, androidCode: Int, url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            mAndroidVersionRepository.insertAndroidVersion(
                ObjectDataSample(androidName, androidCode, url)
            )
        }
    }

    fun deleteAllAndroidVersion() {
        viewModelScope.launch(Dispatchers.IO) {
            mAndroidVersionRepository.deleteAllAndroidVersion()
        }
    }
}