package com.jordroid.android_cloud_2020.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jordroid.android_cloud_2020.model.ObjectDataSample
import com.jordroid.android_cloud_2020.repository.AndroidVersionRepository

class AndroidVersionViewModel : ViewModel() {

    // Create a mutable live data which will contains out data
    var mAndroidVersionLiveData = MutableLiveData<ArrayList<ObjectDataSample>>()
    private val mAndroidVersionRepository: AndroidVersionRepository by lazy { AndroidVersionRepository() }

    init {
        mAndroidVersionLiveData.postValue(mAndroidVersionRepository.generateFakeData())
    }
}