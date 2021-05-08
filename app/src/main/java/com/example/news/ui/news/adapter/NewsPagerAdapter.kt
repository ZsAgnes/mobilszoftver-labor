package com.example.news.ui.news.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import com.example.news.R
import com.example.news.data.network.model.NewsList
import com.example.news.ui.news.newscontent.NewsListFragment

class NewsPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val context: Context,
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val titles = listOf<String>(context.getString(R.string.news_tab_actual), context.getString(
            R.string.news_tab_saved))

    private val fragments = listOf<RainbowCakeFragment<*, *>>(
        NewsListFragment(),
        NewsListFragment()
    )

    override fun getItemCount() = fragments.count()

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun getTitle(position: Int): String = titles[position]
}
