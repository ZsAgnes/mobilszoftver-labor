package com.example.news.mock

import com.example.news.data.disk.dao.NewsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockDiskModule {

    @Provides
    @Singleton
    fun provideMockNewsDao(): NewsDao = MockNewsDao()

}