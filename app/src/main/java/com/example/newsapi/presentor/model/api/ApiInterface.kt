package com.example.heroretrofit.model.api

import com.example.heroretrofit.model.data.Article
import com.example.heroretrofit.model.data.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("top-headlines?sources=techcrunch&apiKey=72d0930c26294a7480a011b663246cd7")
    fun getMovies(@Query("apikey") sort: String): Call<News>



    companion object {

        var BASE_URL = "https://newsapi.org/v2/"

        fun create(): ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}