package com.example.news.ui.news

import co.zsmb.rainbowcake.withIOContext
import com.example.news.domain.NewsInteractor
import javax.inject.Inject

class NewsPresenter @Inject constructor(
    private val newsInteractor: NewsInteractor
) {

    suspend fun getData(): String = withIOContext {
        newsInteractor.getNews()
        ""
    }

}
