package com.jordroid.android_cloud_2020.endpoint

import com.jordroid.android_cloud_2020.model.ChuckNorrisQuote
import retrofit2.http.GET

interface ChuckNorrisQuoteEndpoint {

    @GET("random")
    suspend fun getRandomQuote(): ChuckNorrisQuote
}