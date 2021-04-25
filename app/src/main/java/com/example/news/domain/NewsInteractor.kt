package com.example.news.domain

import com.example.news.data.disk.DiskDataSource
import com.example.news.data.disk.model.RoomArticle
import com.example.news.data.network.NetworkDataSource
import com.example.news.data.network.model.Article
import com.example.news.data.network.model.NewsList
import javax.inject.Inject

class NewsInteractor @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val diskDataSource: DiskDataSource
) {
    suspend fun getNews(): NewsList? {
        return networkDataSource.getAllNews()
    }

    suspend fun getAllSavedNews(): List<RoomArticle> {
        return diskDataSource.getAll()
    }

    suspend fun getNewsById(id: String) {
        // TODO call networkDataSource.getNews(id)
    }

    suspend fun saveNews(article: Article) {
        networkDataSource.saveArticle(article)
        diskDataSource.saveArticle(article)
    }

    suspend fun deleteNews(id: String) {
        networkDataSource.deleteArticle(id)
    }
}