package com.example.retrofitexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteViewModel(private val repo:QuoteRepository):ViewModel() {
    //first make network request request by calling getQuotes() . Then save quotes form repository.
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getQuotes(1)
        }
    }
    val quote:LiveData<QuoteList>
        get() = repo.quotes
}