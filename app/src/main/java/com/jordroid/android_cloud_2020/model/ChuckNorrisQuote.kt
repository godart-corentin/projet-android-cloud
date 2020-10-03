package com.jordroid.android_cloud_2020.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "chuck_norris_quote_table")
data class ChuckNorrisQuote(
    @Expose
    @SerializedName("value")
    val quote: String,
    @Expose
    @SerializedName("icon_url")
    val iconUrl: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}