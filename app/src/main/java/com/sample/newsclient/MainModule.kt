package com.sample.newsclient

import com.sample.newsclient.usecases.FetchNewsListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    fun provideFetchNewsListUseCase(): FetchNewsListUseCase = FetchNewsListUseCase()

}