package com.example.myapplication.api

data class CryptoModel(
   val data: List<CryptoItemModel>
)
data class CryptoItemModel(
    val pair: String,
    val last: Double
)
