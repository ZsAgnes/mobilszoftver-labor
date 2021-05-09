package com.example.news.domain

import com.example.news.data.disk.DiskDataSource
import com.example.news.data.disk.model.RoomArticle
import com.example.news.data.network.NetworkDataSource
import com.example.news.data.network.model.NewsList
import com.example.news.ui.news.newscontent.model.UiArticle
import com.example.news.ui.news.newscontent.model.toArticle
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

    suspend fun saveNews(article: UiArticle): String {
        networkDataSource.saveArticle(article.toArticle())
        return diskDataSource.saveArticle(article)
    }

    suspend fun deleteSavedArticle(articleId: String) {
        diskDataSource.deleteArticle(articleId)
    }

    suspend fun deleteNews(id: String): Boolean {
        return networkDataSource.deleteArticle(id)
    }
}