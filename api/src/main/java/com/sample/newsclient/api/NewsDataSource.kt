package com.sample.newsclient.api

import com.sample.newsclient.api.data.NewsResponse
import com.sample.newsclient.core.coroutines.DispatchersProvider
import com.sample.newsclient.core.networking.toBody
import kotlinx.coroutines.withContext

class NewsDataSource internal constructor(
    private val newsService: NewsService,
    private val dispatchersProvider: DispatchersProvider
) {

    suspend fun fetchTopNews(): List<NewsResponse> = withContext(dispatchersProvider.io) {
        return@withContext newsService.fetchTopNews().toBody().articles
    }

}