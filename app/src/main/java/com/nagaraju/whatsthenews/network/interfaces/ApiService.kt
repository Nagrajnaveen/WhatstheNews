package com.nagaraju.whatsthenews.network.interfaces

import com.nagaraju.whatsthenews.model.NewsResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("everything")
    suspend fun getNewsList(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
        @Query("apiKey") apiKey: String
    ): NewsResponseModel

}