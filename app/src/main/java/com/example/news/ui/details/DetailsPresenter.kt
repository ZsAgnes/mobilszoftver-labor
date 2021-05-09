package com.example.news.ui.details

import co.zsmb.rainbowcake.withIOContext
import com.example.news.domain.NewsInteractor
import com.example.news.ui.news.newscontent.model.UiArticle
import javax.inject.Inject

class DetailsPresenter @Inject constructor(
    private val newsInteractor: NewsInteractor
) {

    suspend fun saveNews(article: UiArticle): String = withIOContext {
        newsInteractor.saveNews(article)
    }

    suspend fun deleteNews(articleId: String) = withIOContext {
        newsInteractor.deleteNews(articleId)
    }

    suspend fun deleteSavedArticle(articleId: String) = withIOContext {
        newsInteractor.deleteSavedArticle(articleId)
    }

}
