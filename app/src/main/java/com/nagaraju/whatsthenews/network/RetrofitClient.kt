package com.nagaraju.whatsthenews.network

import com.nagaraju.whatsthenews.network.interfaces.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://newsapi.org/v2/"

    val apiService: ApiService by lazy {  // lazy initialization is used to create a singleton object
        // ie., only one instance of the object will be created
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}