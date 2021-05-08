package com.example.news.ui.news

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class NewsViewModel @Inject constructor(
) : RainbowCakeViewModel<NewsViewState>(NewsReady) {}
