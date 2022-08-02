package com.sample.newsclient.data.models

data class News(
    val id: Int,
    val url: String,
    val title: String,
    val description: String?,
    val imageUrl: String?
)