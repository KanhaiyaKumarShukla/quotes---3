package com.example.retrofitexample

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val BASE_URL = "https://quotable.io/"

    // return retrofit instance
    fun getInstance() : Retrofit{
        return Retrofit.Builder()                                      // make retrofit builder
            .baseUrl(BASE_URL)                                          // set base url
            .addConverterFactory(GsonConverterFactory.create())         // set converter factory
            .build()                                                    // create object of retrofit from retrofit builder
    }
}