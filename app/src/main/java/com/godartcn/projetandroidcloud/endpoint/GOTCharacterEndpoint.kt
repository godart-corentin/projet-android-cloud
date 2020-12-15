package com.godartcn.projetandroidcloud.endpoint

import com.godartcn.projetandroidcloud.model.GOTCharacter
import retrofit2.http.GET
import retrofit2.http.Url

interface GOTCharacterEndpoint {
    @GET
    suspend fun getRandomCharacter(@Url random:String): GOTCharacter
}