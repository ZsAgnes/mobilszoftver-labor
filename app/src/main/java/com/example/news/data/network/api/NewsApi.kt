package com.example.news.data.network.api

import com.example.news.data.network.model.Article
import com.example.news.data.network.model.NewsList
import retrofit2.http.*

interface NewsApi {
    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): NewsList

    @POST("/v2/news/{userId}")
    suspend fun saveArticle(
        @Path("userId") userId: String,
        @Query("apiKey") apiKey: String,
        @Body article: Article
    )

    @DELETE("/v2/news/{newsId}")
    suspend fun deleteArticle(
        @Path("newsId") newsId: String,
        @Query("apiKey") apiKey: String
    )
}