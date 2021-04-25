package com.example.news.ui.news

import co.zsmb.rainbowcake.withIOContext
import com.example.news.data.network.model.Article
import com.example.news.data.network.model.NewsList
import com.example.news.domain.NewsInteractor
import javax.inject.Inject

class NewsPresenter @Inject constructor(
    private val newsInteractor: NewsInteractor
) {

    suspend fun getData(): NewsList? = withIOContext {
        newsInteractor.getNews()
    }

    suspend fun saveNews(article: Article?) = withIOContext {
        article?.let { newsInteractor.saveNews(it) }
    }

}
