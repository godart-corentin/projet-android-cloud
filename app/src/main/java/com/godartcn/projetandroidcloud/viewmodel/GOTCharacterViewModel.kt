package com.godartcn.projetandroidcloud.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.godartcn.projetandroidcloud.model.Avatar
import com.godartcn.projetandroidcloud.model.GOTCharacter
import com.godartcn.projetandroidcloud.repository.AvatarRepository
import com.godartcn.projetandroidcloud.repository.GOTCharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class GOTCharacterViewModel: ViewModel() {
    private val repository: GOTCharacterRepository by lazy { GOTCharacterRepository() }
    var myData: LiveData<List<GOTCharacter>> = repository.getDataFromDatabase()


    fun fetchNewCharacter(random: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetchData(random)
        }
    }

    fun removeAllData() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeAll()
        }
    }
}