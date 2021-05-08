package com.example.news.ui.details

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.example.news.ui.news.newscontent.model.UiArticle
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val detailsPresenter: DetailsPresenter
) : RainbowCakeViewModel<DetailsViewState>(
    Loading
) {

    fun saveArticle(article: UiArticle) = execute {
        detailsPresenter.saveNews(article)
    }

    fun deleteArticle(articleId: String) = execute {
        detailsPresenter.deleteNews(articleId)
    }

    fun deleteSavedArticle(articleId: String) = execute {
        detailsPresenter.deleteSavedArticle(articleId)
    }

}
