package com.example.news.ui.about

sealed class AboutViewState

object Loading : AboutViewState()

data class AboutReady(val data: String = "") : AboutViewState()
