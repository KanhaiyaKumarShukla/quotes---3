package com.example.retrofitexample

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {

    @Insert
    suspend fun insertQuote(quotes: List<Result>)

    @Query("SELECT * FROM quotes")
    suspend fun getQuotes():List<Result>

}