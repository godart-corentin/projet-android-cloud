package com.godartcn.projetandroidcloud.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.godartcn.projetandroidcloud.model.Avatar
import com.godartcn.projetandroidcloud.repository.AvatarRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class AvatarViewModel: ViewModel() {
    private val repository: AvatarRepository by lazy { AvatarRepository() }
    var myData: LiveData<List<Avatar>> = repository.getDataFromDatabase()


    fun insertData(url: String, content: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(Avatar(null, url, content))
        }
    }

    fun removeData(avatar: Avatar) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeOne(avatar.id)
        }
    }

    fun removeAllData() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeAll()
        }
    }
}