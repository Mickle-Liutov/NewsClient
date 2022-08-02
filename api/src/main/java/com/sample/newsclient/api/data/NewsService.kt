package com.sample.newsclient.api.data

import com.sample.newsclient.api.data.NewsListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface NewsService {

    @GET("top-headlines")
    suspend fun fetchTopNews(@Query("country")country:String = "us"): Response<NewsListResponse>

}