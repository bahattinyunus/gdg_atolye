package com.example.myapplication.repository

import com.example.myapplication.api.CryptoModel
import com.example.myapplication.api.RetrofitInstance

class CryptoRepository {
    private val api = RetrofitInstance.api
    suspend fun getData(): CryptoModel{
        return api.getData()
    }
}