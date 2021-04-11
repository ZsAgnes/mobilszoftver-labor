package com.example.news.domain

import javax.inject.Inject

class NewsInteractor @Inject constructor(
) {
    suspend fun getNews() {
        // TODO call networkDataSource.getNews()
    }

    suspend fun getNewsById(id: String) {
        // TODO call networkDataSource.getNews(id)
    }

    suspend fun saveNews(id: String) {
        // TODO call networkDataSource.saveNews(id)
    }

    suspend fun deleteNews(id: String) {
        // TODO call networkDataSource.deleteNews(id)
    }
}