package com.godartcn.projetandroidcloud.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "avatar")
data class Avatar(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var url: String,
    var content: String,
    var createdAt: Long? = null
)