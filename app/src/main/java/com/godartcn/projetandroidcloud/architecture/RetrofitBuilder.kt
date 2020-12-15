package com.godartcn.projetandroidcloud.architecture

import com.google.gson.GsonBuilder
import com.godartcn.projetandroidcloud.endpoint.GOTCharacterEndpoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://anapioficeandfire.com/api/characters/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
        .build()

    fun getGOTCharacter(): GOTCharacterEndpoint = retrofit.create(GOTCharacterEndpoint::class.java)
}