package com.example.news.data.disk

import com.example.news.data.disk.dao.NewsDao
import com.example.news.data.disk.model.RoomArticle
import com.example.news.data.disk.model.toRoomArticle
import com.example.news.data.network.model.Article
import javax.inject.Inject

class DiskDataSource @Inject constructor(
    private val newsDao: NewsDao
) {

    suspend fun getAll(): List<RoomArticle> {
        return newsDao.getAll()
    }

    suspend fun saveArticle(article: Article) {
        newsDao.saveArticle(
            article.toRoomArticle()
        )
    }
}
