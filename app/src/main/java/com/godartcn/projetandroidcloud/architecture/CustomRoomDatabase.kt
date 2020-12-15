package com.godartcn.projetandroidcloud.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.godartcn.projetandroidcloud.dao.AvatarDAO
import com.godartcn.projetandroidcloud.model.Avatar
import com.godartcn.projetandroidcloud.dao.GOTCharacterDAO
import com.godartcn.projetandroidcloud.model.GOTCharacter

@Database(
    entities = [
        Avatar::class,
        GOTCharacter::class
    ],
    version = 11,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun mAvatarDao(): AvatarDAO
    abstract fun mGOTCharacterDao() : GOTCharacterDAO
}
