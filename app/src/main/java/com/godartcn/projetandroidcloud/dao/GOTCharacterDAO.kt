package com.godartcn.projetandroidcloud.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.godartcn.projetandroidcloud.model.GOTCharacter

@Dao
interface GOTCharacterDAO {
    @Query("SELECT * FROM got_character")
    fun selectAll(): LiveData<List<GOTCharacter>>

    @Insert
    fun insert(myData: GOTCharacter)

    @Query("DELETE FROM got_character")
    fun deleteAll()
}