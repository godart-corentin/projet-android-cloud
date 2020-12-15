package com.godartcn.projetandroidcloud.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.godartcn.projetandroidcloud.model.Avatar

@Dao
interface AvatarDAO {
    @Query("SELECT * FROM avatar")
    fun selectAll(): LiveData<List<Avatar>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(myData: List<Avatar>): List<Long>

    @Insert
    fun insert(myData: Avatar)

    fun insertWithTimestamp(myData: Avatar) {
        insert(
            myData.apply{
                createdAt = System.currentTimeMillis()
            }
        )
    }

    @Query("DELETE FROM avatar")
    fun deleteAll()

    @Query("DELETE FROM avatar WHERE id = :id")
    fun deleteOne(id: Long?)
}