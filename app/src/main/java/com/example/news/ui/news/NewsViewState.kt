package com.example.news.ui.news

import com.example.news.data.network.model.NewsList

sealed class NewsViewState

object NewsReady: NewsViewState()
