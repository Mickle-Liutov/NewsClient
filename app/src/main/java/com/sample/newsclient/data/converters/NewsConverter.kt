package com.sample.newsclient.data.converters

import com.sample.newsclient.api.data.NewsResponse
import com.sample.newsclient.data.models.News

class NewsConverter {

    fun fromResponse(newsResponse: NewsResponse): News {
        return with(newsResponse) {
            News("1", url, title, imageUrl,"") //TODO Set id, content
        }
    }

}