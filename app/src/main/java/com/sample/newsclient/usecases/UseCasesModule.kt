package com.sample.newsclient.usecases

import com.sample.newsclient.data.NewsRepository
import com.sample.newsclient.usecases.FetchNewsDetailsUseCase
import com.sample.newsclient.usecases.FetchNewsListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    fun provideFetchNewsListUseCase(newsRepository: NewsRepository): FetchNewsListUseCase =
        FetchNewsListUseCase(newsRepository)

    @Provides
    fun provideFetchNewsDetailsUseCase(newsRepository: NewsRepository): FetchNewsDetailsUseCase =
        FetchNewsDetailsUseCase(newsRepository)

}