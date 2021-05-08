package com.example.news.ui.about

import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.example.news.R

class AboutFragment : RainbowCakeFragment<AboutViewState, AboutViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_about

    override fun render(viewState: AboutViewState) {}
}
