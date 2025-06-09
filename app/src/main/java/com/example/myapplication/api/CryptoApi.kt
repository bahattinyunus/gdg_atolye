package com.example.myapplication.api

import retrofit2.http.GET

interface CryptoApi {
    @GET("api/v2/ticker")
    suspend fun  getData(): CryptoModel


}