package com.example.news.ui.news.newscontent.model

import com.example.news.data.disk.model.RoomArticle
import com.example.news.data.network.model.Article
import com.example.news.data.network.model.Source
import kotlinx.serialization.Serializable

@Serializable
data class UiArticle(
    var id: String,
    val author: String?,
    val content: String?,
    val description: String,
    val publishedAt: String,
    val sourceId: String?,
    val sourceName: String,
    val title: String,
    val url: String,
    val urlToImage: String,
    val saved: Boolean
)

fun Article.toUiArticle() = UiArticle(
    id = "",
    author = author,
    content = content,
    description = description,
    publishedAt = publishedAt,
    sourceId = source.id,
    sourceName = source.name,
    title = title,
    url = url,
    urlToImage = urlToImage,
    saved = false
)

fun RoomArticle.toUiArticle() = UiArticle(
    id = id,
    author = author,
    content = content,
    description = description,
    publishedAt = publishedAt,
    sourceId = sourceId,
    sourceName = sourceName,
    title = title,
    url = url,
    urlToImage = urlToImage,
    saved = true
)


fun UiArticle.toArticle() = Article(
    author = author,
    content = content,
    description = description,
    publishedAt = publishedAt,
    source = Source(id = sourceId, name = sourceName),
    title = title,
    url = url,
    urlToImage = urlToImage
)