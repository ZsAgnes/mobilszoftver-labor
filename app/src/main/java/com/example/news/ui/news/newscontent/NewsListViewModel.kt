package com.example.news.ui.news.newscontent

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.example.news.ui.news.newscontent.model.toUiArticle
import javax.inject.Inject

class NewsListViewModel @Inject constructor(
    private val newsListPresenter: NewsListPresenter
) : RainbowCakeViewModel<NewsListViewState>(Loading) {

    fun loadActualNews() = execute {
        val listOfArticles = newsListPresenter.loadActualNews()
        val list = listOfArticles?.map { article -> article.toUiArticle() }
        viewState = NewsListReady(list ?: listOf())
    }

    fun loadSavedNews() = execute {
        val listOfArticles = newsListPresenter.loadSavedNews()
        val list = listOfArticles.map { article -> article.toUiArticle() }
        viewState = NewsListReady(list)
    }
}
