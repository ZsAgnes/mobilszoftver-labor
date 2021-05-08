package com.example.news.ui.news.newscontent

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.example.news.R

class NewsListFragment : RainbowCakeFragment<NewsListViewState, NewsListViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_news_list


    val pageTitle: Int
        get() {

            //TODO add back real title
            return R.string.news_fragment_title
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun render(listViewState: NewsListViewState) {

    }

}
