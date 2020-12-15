package com.godartcn.projetandroidcloud.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "got_character")
data class GOTCharacter(
    @Expose
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    @Expose
    @SerializedName("name")
    val name: String? = null,
    @Expose
    @SerializedName("gender")
    val gender: String? = null,
    @Expose
    @SerializedName("culture")
    val culture: String? = null,
    @Expose
    @SerializedName("born")
    val born: String? = null,
    @Expose
    @SerializedName("died")
    val died: String? = null,
)