package com.example.news.data.disk

import com.example.news.data.disk.dao.NewsDao
import com.example.news.data.disk.model.RoomArticle
import com.example.news.data.disk.model.toRoomArticle
import com.example.news.ui.news.newscontent.model.UiArticle
import javax.inject.Inject

class DiskDataSource @Inject constructor(
    private val newsDao: NewsDao
) {

    suspend fun getAll(): List<RoomArticle> {
        return newsDao.getAll()
    }

    suspend fun saveArticle(article: UiArticle) {
        newsDao.saveArticle(article.toRoomArticle())
    }

    suspend fun deleteArticle(articleId: String) {
        newsDao.deleteArticleById(articleId)
    }
}
