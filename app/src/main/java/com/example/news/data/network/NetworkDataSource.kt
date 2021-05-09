package com.example.news.data.network

import com.example.news.data.network.api.NewsApi
import com.example.news.data.network.model.Article
import com.example.news.data.network.model.NewsList
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(
    private val newsApi: NewsApi
) {
    suspend fun getAllNews(): NewsList? {
        return newsApi.getTopHeadlines(country = "hu", apiKey = "3cedc53d3ea34f1d9644f954294493ef")
            .body()
    }

    suspend fun saveArticle(article: Article): Boolean {
        return newsApi.saveArticle(
            userId = UUID.randomUUID().toString(),
            apiKey = "3cedc53d3ea34f1d9644f954294493ef",
            article = article
        ).isSuccessful
    }

    suspend fun deleteArticle(newsId: String): Boolean {
        return newsApi.deleteArticle(
            newsId = newsId,
            apiKey = "3cedc53d3ea34f1d9644f954294493ef"
        ).isSuccessful
    }
}