package com.example.retrofitexample

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class QuoteRepository(private val quoteService:QuoteAPI, private val quoteDatabase: QuoteDatabase, private val context: Context) {
    private val quotesLiveData=MutableLiveData<QuoteList>()
    val quotes: LiveData<QuoteList>
        get() = quotesLiveData
    /*
    * Here we are making a mechanism that, when network connection is available, we will use API. Otherwise, we will use data from database */
    suspend fun getQuotes(page:Int){
        // we have defined isInternetAvailable() in NetworkUtils class which return true if network connection is available.
        if(NetworkUtils.isInternetAvailable(context)) {
            // if network connection is available, we will get data from API and insert them into our livedata and store them into database.
            val result = quoteService.getQuotes(page)
            if (result.body() != null) {
                quoteDatabase.quoteDao().insertQuote(result.body()!!.results)
                quotesLiveData.postValue(result.body())
            }
        }else{
            // if network connection is not available, we will use data from database.
            val quotes=quoteDatabase.quoteDao().getQuotes()

            //as database have quotes only, but livedata type is quoteList, we will create dummy data.
            // we just need quotes so we have made a dummy quoteList, where quotes parameter have valid value, but other parameter have random values.
            val quoteList=QuoteList(1, 1, 1, quotes, 1, 1 )
            quotesLiveData.postValue(quoteList)
        }
    }
}