package com.sample.newsclient.usecases

import com.sample.newsclient.data.NewsRepository
import com.sample.newsclient.data.models.News

class FetchNewsDetailsUseCase(private val newsRepository: NewsRepository) {

    suspend fun invoke(): News {
        //TODO Implement
        return News("", "https://google.com", "Test post", "Content of a long post", null)
    }

}