package com.example.news.ui.news.newscontent

import co.zsmb.rainbowcake.withIOContext
import com.example.news.data.disk.model.RoomArticle
import com.example.news.data.network.model.Article
import com.example.news.domain.NewsInteractor
import javax.inject.Inject

class NewsListPresenter @Inject constructor(
    private val newsInteractor: NewsInteractor
) {

    suspend fun loadActualNews(): List<Article>? = withIOContext {
        newsInteractor.getNews()?.articles
    }

    suspend fun loadSavedNews(): List<RoomArticle> = withIOContext {
        newsInteractor.getAllSavedNews()
    }

}
