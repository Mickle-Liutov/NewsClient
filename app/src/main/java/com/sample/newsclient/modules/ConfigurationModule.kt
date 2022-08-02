package com.sample.newsclient.modules

import android.content.Context
import com.sample.newsclient.R
import com.sample.newsclient.api.ApiConfig
import com.sample.newsclient.secrets.SimpleSecretsProvider
import com.sample.newsclient.secrets.SecretsProvider
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ConfigurationModule {
    @Provides
    @Reusable
    fun provideApiConfig(
        @ApplicationContext context: Context,
        secretsProvider: SecretsProvider
    ): ApiConfig =
        ApiConfig(
            context.getString(R.string.news_api_base_url),
            secretsProvider.provideNewsApiKey()
        )

    @Provides
    @Reusable
    fun provideSimpleSecretsProvider(): SecretsProvider = SimpleSecretsProvider()
}