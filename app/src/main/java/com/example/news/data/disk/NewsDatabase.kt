package com.example.news.data.disk

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.news.data.disk.dao.NewsDao
import com.example.news.data.disk.model.RoomArticle

@Database(
    version = 1,
    exportSchema = true,
    entities = [
        RoomArticle::class
    ]
)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
}
