package com.sample.newsclient.api

import com.sample.newsclient.api.moshi.ZonedDateTimeAdapter
import com.sample.newsclient.core.coroutines.DispatchersProvider
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    internal fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(ZonedDateTimeAdapter)
            .build()

    @Provides
    @Singleton
    internal fun provideAuthInterceptor(apiConfig: ApiConfig): AuthInterceptor =
        AuthInterceptor(apiConfig.apiKey)

    @Provides
    @Singleton
    internal fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient =
        OkHttpClient().newBuilder()
            .addInterceptor(authInterceptor)
            .build()

    @Provides
    @Singleton
    internal fun provideRetrofit(
        moshi: Moshi,
        okHttpClient: OkHttpClient,
        apiConfig: ApiConfig
    ): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(apiConfig.baseUrl)
            .build()

    @Provides
    @Singleton
    internal fun provideNewsService(retrofit: Retrofit): NewsService =
        retrofit.create(NewsService::class.java)

    @Provides
    @Reusable
    internal fun provideNewsDataSource(
        newsService: NewsService,
        dispatchersProvider: DispatchersProvider
    ): NewsDataSource =
        NewsDataSource(newsService, dispatchersProvider)
}