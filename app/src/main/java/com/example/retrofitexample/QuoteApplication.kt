package com.example.retrofitexample

import android.app.Application

class QuoteApplication :Application() {
    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteAPI = RetrofitHelper.getInstance().create(QuoteAPI::class.java)
        val quoteDatabase=QuoteDatabase.getDatabaseInstance(applicationContext)
        quoteRepository=QuoteRepository(quoteAPI, quoteDatabase, applicationContext)
    }
}