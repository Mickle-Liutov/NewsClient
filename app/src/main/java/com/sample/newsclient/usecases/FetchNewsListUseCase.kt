package com.sample.newsclient.usecases

import com.sample.newsclient.data.NewsRepository
import com.sample.newsclient.data.models.News

class FetchNewsListUseCase(private val newsRepository: NewsRepository) {

    suspend fun invoke(): List<News> {
        return newsRepository.fetchTopNews()
    }

}