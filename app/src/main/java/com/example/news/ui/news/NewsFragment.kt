package com.example.news.ui.news

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.example.news.R
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : RainbowCakeFragment<NewsViewState, NewsViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_news

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllNews.setOnClickListener {
            viewModel.load()
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun render(viewState: NewsViewState) {
        when (viewState) {
            is NewsReady -> newsText.text = viewState.data?.totalResults.toString()
        }
    }

}
