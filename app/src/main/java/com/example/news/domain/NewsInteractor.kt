package com.example.news.domain

import com.example.news.data.network.NetworkDataSource
import com.example.news.data.network.model.NewsList
import javax.inject.Inject

class NewsInteractor @Inject constructor(
    private val networkDataSource: NetworkDataSource
) {
    suspend fun getNews(): NewsList? {
        return networkDataSource.getAllNews()

    }

    suspend fun getNewsById(id: String) {
        // TODO call networkDataSource.getNews(id)
    }

    suspend fun saveNews(id: String) {
        networkDataSource.saveArticle()
    }

    suspend fun deleteNews(id: String) {
        networkDataSource.deleteArticle(id)
    }
}