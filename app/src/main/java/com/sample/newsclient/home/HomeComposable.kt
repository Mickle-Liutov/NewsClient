package com.sample.newsclient.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.sample.newsclient.core.Content
import com.sample.newsclient.core.Failure
import com.sample.newsclient.core.Progress
import com.sample.newsclient.models.News
import com.sample.newsclient.ui.composables.ErrorMessage
import com.sample.newsclient.ui.composables.Loader

@Preview
@Composable
private fun HomePreview() {
    HomeContent(
        newsItems = listOf(
            News("1", "Title 1", "https://picsum.photos/200"),
            News("1", "Title 2", "https://picsum.photos/200"),
            News("1", "Title 3", "https://picsum.photos/200"),
        )
    )
}

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val screenState = viewModel.screenState.collectAsState()
    when (val state = screenState.value) {
        is Content -> HomeContent(newsItems = state.content)
        is Failure -> ErrorMessage(e = state.exception)
        Progress -> Loader()
    }
}

@Composable
private fun HomeContent(newsItems: List<News>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(newsItems) {
            HomeRow(newsItem = it)
        }
    }
}

@Composable
private fun HomeRow(newsItem: News) {
    Column(modifier = Modifier.fillMaxWidth()) {
        AsyncImage(
            model = newsItem.imageUrl,
            contentDescription = "",
            modifier = Modifier.fillMaxWidth()
        )//TODO CD
        Text(text = newsItem.title)
    }
}