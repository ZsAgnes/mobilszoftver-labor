package com.example.news.ui.details

import co.zsmb.rainbowcake.withIOContext
import com.example.news.domain.NewsInteractor
import javax.inject.Inject

class DetailsPresenter @Inject constructor(
    private val newsInteractor: NewsInteractor
) {

    suspend fun getData(id: String): String = withIOContext {

    ""
    }

}
