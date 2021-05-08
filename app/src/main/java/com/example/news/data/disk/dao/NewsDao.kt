package com.example.news.data.disk.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.news.data.disk.model.RoomArticle

@Dao
interface NewsDao {
    @Query("SELECT * FROM news")
    suspend fun getAll(): List<RoomArticle>

    @Insert
    suspend fun saveArticle(article: RoomArticle)

    @Query("DELETE FROM news WHERE id = :articleId")
    suspend fun deleteArticleById(articleId: String)
}
