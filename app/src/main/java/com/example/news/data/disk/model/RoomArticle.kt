package com.example.news.data.disk.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.news.ui.news.newscontent.model.UiArticle
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

fun UiArticle.toRoomArticle() = RoomArticle(
    id = if (id.isEmpty()) UUID.randomUUID().toString() else id,
    author = author,
    content = content,
    description = description,
    publishedAt = publishedAt,
    sourceId = sourceId,
    sourceName = sourceName,
    title = title,
    url = url,
    urlToImage = urlToImage
)