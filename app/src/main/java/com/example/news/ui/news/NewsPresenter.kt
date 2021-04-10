package com.example.news.ui.news

import co.zsmb.rainbowcake.withIOContext
import javax.inject.Inject

class NewsPresenter @Inject constructor() {

    suspend fun getData(): String = withIOContext {
        ""
    }

}
