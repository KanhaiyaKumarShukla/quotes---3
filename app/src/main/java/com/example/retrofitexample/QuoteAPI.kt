package com.example.retrofitexample

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteAPI {

    /*
    * we have URL : https://quotable.io/quotes?page=1
    * Here, https://quotable.io/ is part is base url, "/quotes" is endpoint and "page=1" is a query.
    */
    //This is a Retrofit annotation used to specify the HTTP request method, which is a GET request in this case. The parameter inside the annotation is the relative URL endpoint for the API call.
    // Here, "/quotes" represents the endpoint to fetch quotes.
    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page:Int): Response<QuoteList>
    /*
    * Query parameters are used to specify a query parameter for the GET request.  In this case, it's named page, and it accepts an integer value. For example, if page is 1, the resulting URL might be /quotes?page=1.
    *   */
}
