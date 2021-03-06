package com.example.news.ui.details

sealed class DetailsViewState

object Loading : DetailsViewState()

data class DetailsReady(val data: String = "") : DetailsViewState()
