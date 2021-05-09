package com.example.news.data.disk

import android.content.Context
import androidx.room.Room
import com.example.news.data.disk.dao.NewsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class DiskModule {

    companion object {
        private const val DB_NEWS = "news.db"

        @Provides
        @Singleton
        fun provideNewsDatabase(context: Context): NewsDatabase {
            return Room.databaseBuilder(
                context,
                NewsDatabase::class.java,
                DB_NEWS
            )
                .fallbackToDestructiveMigration()
                .build()
        }

        @Provides
        @Singleton
        fun provideNewsDao(newsDatabase: NewsDatabase): NewsDao {
            return newsDatabase.newsDao()
        }
    }
}
