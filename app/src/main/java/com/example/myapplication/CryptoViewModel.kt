package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.api.CryptoItemModel

import com.example.myapplication.repository.CryptoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

    class CryptoViewModel : ViewModel() {
        private val repository = CryptoRepository()
        private val _state = MutableStateFlow<List<CryptoItemModel>>(emptyList())
        val state: StateFlow<List<CryptoItemModel>> = _state

        init {
            fetchData()
        }
        private fun fetchData() {
            viewModelScope.launch {
               _state.value = repository.getData().data
            }
        }
    }
