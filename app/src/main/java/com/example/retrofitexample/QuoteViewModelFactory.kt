package com.example.retrofitexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class QuoteViewModelFactory(private val repository: QuoteRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuoteViewModel(repository) as T
    }
}