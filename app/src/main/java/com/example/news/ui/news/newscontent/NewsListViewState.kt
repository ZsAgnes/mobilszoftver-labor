package com.example.news.ui.news.newscontent

import com.example.news.data.network.model.NewsList

sealed class NewsListViewState

object Loading : NewsListViewState()

data class NewsListReady(val data: NewsList?) : NewsListViewState()
