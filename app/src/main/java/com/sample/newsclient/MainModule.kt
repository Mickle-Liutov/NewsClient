package com.sample.newsclient

import android.content.Context
import com.sample.newsclient.api.ApiConfig
import com.sample.newsclient.api.NewsDataSource
import com.sample.newsclient.data.NewsRepository
import com.sample.newsclient.data.converters.NewsConverter
import com.sample.newsclient.secrets.SecretsProvider
import com.sample.newsclient.usecases.FetchNewsDetailsUseCase
import com.sample.newsclient.usecases.FetchNewsListUseCase
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    fun provideNewsConverter(): NewsConverter = NewsConverter()

    @Provides
    @Reusable
    fun provideNewsRepository(
        newsDataSource: NewsDataSource,
        newsConverter: NewsConverter
    ): NewsRepository = NewsRepository(newsDataSource, newsConverter)

    @Provides
    fun provideFetchNewsListUseCase(newsRepository: NewsRepository): FetchNewsListUseCase =
        FetchNewsListUseCase(newsRepository)

    @Provides
    fun provideFetchNewsDetailsUseCase(newsRepository: NewsRepository): FetchNewsDetailsUseCase =
        FetchNewsDetailsUseCase(newsRepository)

}