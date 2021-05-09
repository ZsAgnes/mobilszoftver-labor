package com.example.news.data.network.api

import com.example.news.data.network.model.Article
import com.example.news.data.network.model.NewsList
import retrofit2.Response
import retrofit2.http.*

interface NewsApi {
    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Response<NewsList>

    @POST("/v2/news/{userId}")
    suspend fun saveArticle(
        @Path("userId") userId: String,
        @Query("apiKey") apiKey: String,
        @Body article: Article
    ): Response<Unit>

    @DELETE("/v2/news/{newsId}")
    suspend fun deleteArticle(
        @Path("newsId") newsId: String,
        @Query("apiKey") apiKey: String
    ): Response<Unit>
}