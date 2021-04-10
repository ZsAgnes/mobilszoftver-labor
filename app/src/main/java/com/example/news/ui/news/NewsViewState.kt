package com.example.news.ui.news

sealed class NewsViewState

object Loading : NewsViewState()

data class NewsReady(val data: String = "") : NewsViewState()
