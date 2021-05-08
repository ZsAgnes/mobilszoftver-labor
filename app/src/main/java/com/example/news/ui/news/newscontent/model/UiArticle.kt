package com.example.news.ui.news.newscontent.model

import com.example.news.data.disk.model.RoomArticle
import com.example.news.data.network.model.Article
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class UiArticle(
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

fun Article.toUiArticle() = UiArticle(
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

fun RoomArticle.toUiArticle() = UiArticle(
    id = UUID.randomUUID().toString(),
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