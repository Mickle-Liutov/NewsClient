package com.sample.newsclient.data.models

data class News(
    val id: String,
    val url: String,
    val title: String,
    val content: String?,
    val imageUrl: String?
)