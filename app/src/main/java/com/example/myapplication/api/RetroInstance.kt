package com.example.myapplication.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


    object RetrofitInstance {

        val api: CryptoApi by lazy {

            Retrofit.Builder()

                .baseUrl("https://api.btcturk.com/")

                .addConverterFactory(GsonConverterFactory.create())

                .build()

                .create(CryptoApi::class.java)

        }

    }
