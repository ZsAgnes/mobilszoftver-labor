package com.example.news.ui.news

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val newsPresenter: NewsPresenter
) : RainbowCakeViewModel<NewsViewState>(Loading) {

    fun load() = execute {
        viewState = NewsReady(newsPresenter.getData())
    }

    fun saveNews() = execute {
        val article = (viewState as NewsReady).data?.articles?.get(0)
        newsPresenter.saveNews(article)
    }

}
