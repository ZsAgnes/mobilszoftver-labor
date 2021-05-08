package com.example.news.ui.news.newscontent

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class NewsListViewModel @Inject constructor(
    private val newsListPresenter: NewsListPresenter
) : RainbowCakeViewModel<NewsListViewState>(Loading) {

    fun load() = execute {
        viewState = NewsListReady(newsListPresenter.getData())
    }

}
