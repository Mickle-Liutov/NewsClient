package com.sample.newsclient.data

import android.content.Context
import androidx.room.Room
import com.sample.newsclient.api.data.NewsDataSource
import com.sample.newsclient.data.converters.NewsEntityConverter
import com.sample.newsclient.data.converters.NewsResponseConverter
import com.sample.newsclient.data.local.NewsDao
import com.sample.newsclient.data.local.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideNewsDatabase(@ApplicationContext context: Context): NewsDatabase =
        Room.inMemoryDatabaseBuilder(context, NewsDatabase::class.java)
            .build()

    @Singleton
    @Provides
    fun provideNewsDao(newsDatabase: NewsDatabase): NewsDao = newsDatabase.newsDao()

    @Provides
    fun provideNewsResponseConverter(): NewsResponseConverter = NewsResponseConverter()

    @Provides
    fun provideNewsEntityConverter(): NewsEntityConverter = NewsEntityConverter()

    @Provides
    @Reusable
    fun provideNewsRepository(
        newsDataSource: NewsDataSource,
        newsDao: NewsDao,
        newsResponseConverter: NewsResponseConverter,
        newsEntityConverter: NewsEntityConverter
    ): NewsRepository =
        NewsRepository(newsDataSource, newsDao, newsResponseConverter, newsEntityConverter)
}