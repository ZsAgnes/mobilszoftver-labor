package com.example.news.ui.news.newscontent

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireBoolean
import com.example.news.R
import com.example.news.ui.news.newscontent.adapter.NewsAdapter
import com.example.news.ui.news.newscontent.model.UiArticle
import kotlinx.android.synthetic.main.fragment_news_list.*

class NewsListFragment : RainbowCakeFragment<NewsListViewState, NewsListViewModel>,
    NewsAdapter.Listener {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_news_list

    // A public no-arg constructor to be only used by the framework
    // Clients will be redirected to use the `newInstance` method instead via the deprecation notice
    @Suppress("ConvertSecondaryConstructorToPrimary")
    @Deprecated(
        message = "Use newInstance instead",
        replaceWith = ReplaceWith("NewsListFragment.newInstance()")
    )
    constructor()

    companion object {
        private const val IS_ACTUAL_PAGE = "IS_ACTUAL_PAGE"

        @Suppress("DEPRECATION")
        fun newActualInstance(): NewsListFragment {
            return NewsListFragment().applyArgs {
                putBoolean(IS_ACTUAL_PAGE, true)
            }
        }

        @Suppress("DEPRECATION")
        fun newSavedInstance(): NewsListFragment {
            return NewsListFragment().applyArgs {
                putBoolean(IS_ACTUAL_PAGE, false)
            }
        }
    }

    private var isActualPage: Boolean? = null
    private lateinit var adapter: NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initArguments()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = NewsAdapter()
        adapter.listener = this
        newsList.adapter = adapter
    }


    private fun initArguments() {
        isActualPage = requireArguments().requireBoolean(IS_ACTUAL_PAGE)
    }

    override fun onStart() {
        super.onStart()

        if (isActualPage!!) {
            viewModel.loadActualNews()
        } else {
            viewModel.loadSavedNews()
        }
    }

    override fun render(viewState: NewsListViewState) {
        when (viewState) {
            is NewsListReady -> adapter.submitList(viewState.data)
        }
    }

    override fun onItemSelected(article: UiArticle) {
//        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        newsList.adapter = null
    }
}
