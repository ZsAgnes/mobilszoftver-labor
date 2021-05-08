package com.example.news.ui.news.newscontent

import com.example.news.ui.news.newscontent.model.UiArticle

sealed class NewsListViewState

object Loading : NewsListViewState()

data class NewsListReady(val data: List<UiArticle>) : NewsListViewState()
