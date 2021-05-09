package com.example.news.mock

import com.example.news.data.network.api.NewsApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockNetworkModule {

    @Provides
    @Singleton
    fun provideMockNewsApi(): NewsApi {
        return MockNewsApi()
    }
}