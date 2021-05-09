package com.example.news

import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import com.example.news.di.AppComponent
import com.example.news.di.ViewModelModule
import com.example.news.mock.MockDiskModule
import com.example.news.mock.MockNetworkModule
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MockNetworkModule::class,
        MockDiskModule::class,
        ViewModelModule::class,
        RainbowCakeModule::class
    ]
)
@ExperimentalCoroutinesApi
interface TestAppComponent : AppComponent {
    fun inject(newsInteractorTest: NewsInteractorTest)
}