package com.sample.newsclient.core.coroutines

import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {

    @Provides
    @Reusable
    fun provideDispatchersProvider(): DispatchersProvider = DispatchersProvider(
        Dispatchers.Main, Dispatchers.IO, Dispatchers.Default
    )

}