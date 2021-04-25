package com.example.news.ui.news

import com.example.news.data.network.model.NewsList

sealed class NewsViewState

object Loading : NewsViewState()

data class NewsReady(val data: NewsList?) : NewsViewState()
