package com.example.news.ui.news

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.example.news.R
import com.example.news.ui.news.adapter.NewsPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment :
    RainbowCakeFragment<NewsViewState, NewsViewModel>() {

    companion object {
        private const val PAGE_CURRENT = 0
    }

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_news

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        setupViewPager()
    }

    private fun setupToolbar() {
        toolbarAbout.setOnClickListener {
            // TODO
        }
    }

    private fun setupViewPager() {
        val newsPagerAdapter = NewsPagerAdapter(
            context = requireContext(),
            lifecycle = lifecycle,
            fragmentManager = childFragmentManager
        )
        newsFragmentViewPager.adapter = newsPagerAdapter
        TabLayoutMediator(tabLayout, newsFragmentViewPager) { tab, position ->
            tab.text = newsPagerAdapter.getTitle(position)
        }.attach()
        newsFragmentViewPager.currentItem = PAGE_CURRENT
    }

    override fun onDestroyView() {
        newsFragmentViewPager.adapter = null

        super.onDestroyView()
    }

    override fun render(viewState: NewsViewState) = Unit

}
