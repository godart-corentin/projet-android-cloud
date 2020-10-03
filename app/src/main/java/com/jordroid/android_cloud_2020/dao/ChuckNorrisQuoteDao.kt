package com.jordroid.android_cloud_2020.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jordroid.android_cloud_2020.model.ChuckNorrisQuote

@Dao
interface ChuckNorrisQuoteDao {

    @Query("SELECT * FROM chuck_norris_quote_table ORDER BY id ASC")
    fun selectAll(): LiveData<List<ChuckNorrisQuote>>

    @Insert()
    fun insert(starWardQuote: ChuckNorrisQuote)

    @Query("DELETE FROM chuck_norris_quote_table")
    fun deleteAll()
}