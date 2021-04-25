package com.example.news.data.disk.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.news.data.network.model.Article
import java.util.*

@Entity(tableName = "news")
data class RoomArticle(
    @PrimaryKey
    val id: String,
    val author: String?,
    val content: String?,
    val description: String,
    val publishedAt: String,
    val sourceId: String?,
    val sourceName: String,
    val title: String,
    val url: String,
    val urlToImage: String
)

fun Article.toRoomArticle() = RoomArticle(
    id = UUID.randomUUID().toString(),
    author = author,
    content = content,
    description = description,
    publishedAt = publishedAt,
    sourceId = source.id,
    sourceName = source.name,
    title = title,
    url = url,
    urlToImage = urlToImage
)