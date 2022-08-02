package com.sample.newsclient.details

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.sample.newsclient.R
import com.sample.newsclient.core.Content
import com.sample.newsclient.core.Failure
import com.sample.newsclient.core.Progress
import com.sample.newsclient.core.context.startWebIntent
import com.sample.newsclient.data.models.News
import com.sample.newsclient.ui.composables.ErrorMessage
import com.sample.newsclient.ui.composables.Loader

@Preview
@Composable
fun DetailsScreenPreview() {
    DetailsContent(news = News(0, "", "Title", "Content of the news", "")) {}
}

@Composable
fun DetailsScreen(navController: NavController, viewModel: DetailsViewModel = hiltViewModel()) {
    val screenState = viewModel.screenState.collectAsState()
    when (val state = screenState.value) {
        is Content -> DetailsContent(news = state.content) {
            navController.popBackStack()
        }
        is Failure -> ErrorMessage(e = state.exception)
        Progress -> Loader()
    }
}

@Composable
fun DetailsContent(news: News, onBackPressed: () -> Unit) {
    val scrollState = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.scrollable(
            state = scrollState,
            orientation = Orientation.Vertical
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxWidth()
        ) {
            Button(onClick = onBackPressed) {
                Text(text = stringResource(id = R.string.details_button_back))
            }
        }
        AsyncImage(
            model = news.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .aspectRatio(2.0f)
                .padding(top = 16.dp)
        )
        Text(
            text = news.title,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )
        Text(
            text = news.description.orEmpty(),
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp)
        )
        val context = LocalContext.current
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(onClick = { context.startWebIntent(news.url) }) {
                Text(text = stringResource(id = R.string.details_button_read_more))
            }
        }
    }
}