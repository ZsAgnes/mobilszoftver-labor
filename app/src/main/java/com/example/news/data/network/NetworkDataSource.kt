package com.example.news.data.network

import android.content.Context
import com.example.news.R
import com.example.news.data.network.api.MockNewsApi
import com.example.news.data.network.api.NewsApi
import com.example.news.data.network.model.Article
import com.example.news.data.network.model.NewsList
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(
    private val newsApi: NewsApi,
    private val mockNewsApi: MockNewsApi,
    private val context: Context
) {
    suspend fun getAllNews(): NewsList? {
        return newsApi.getTopHeadlines(country = "hu", apiKey = context.getString(R.string.apiKey))
    }

    suspend fun saveArticle(article: Article) {
        mockNewsApi.saveArticle(
            userId = UUID.randomUUID().toString(),
            apiKey = context.getString(R.string.apiKey),
            article = article
        )
    }

    suspend fun deleteArticle(newsId: String) {
        mockNewsApi.deleteArticle(newsId = newsId, apiKey = context.getString(R.string.apiKey))
    }
}