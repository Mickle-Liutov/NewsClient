package com.sample.newsclient.usecases

import com.sample.newsclient.models.News

class FetchNewsListUseCase {

    suspend fun invoke(): List<News> {
        //TODO Implement
        return listOf(
            News("1", "Title 1", "https://picsum.photos/200"),
            News("1", "Title 2", "https://picsum.photos/200"),
            News("1", "Title 3", "https://picsum.photos/200"),
        )
    }

}