package com.sample.newsclient.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.sample.newsclient.data.models.News
import com.sample.newsclient.ui.composables.ErrorMessage
import com.sample.newsclient.ui.composables.Loader

@Preview
@Composable
private fun HomePreview() {
    HomeContent(
        newsItems = listOf(
            News(1, "1", "Title 1", "", ""),
            News(2, "1", "Title 2", "", ""),
            News(3, "1", "Title 3", "", ""),
        )
    ) {}
}

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel(), navController: NavController) {
    val screenState = viewModel.screenState.collectAsState()
    when (val state = screenState.value) {
        is Content -> HomeContent(newsItems = state.content) {
            navController.navigate("details/${it.id}")
        }
        is Failure -> ErrorMessage(e = state.exception)
        Progress -> Loader()
    }
}

@Composable
private fun HomeContent(newsItems: List<News>, onNavigateDetails: (News) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(newsItems) { index, item ->
            HomeRow(newsItem = item, onNavigateDetails)
            if (index < newsItems.lastIndex) {
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
private fun HomeRow(newsItem: News, onNavigateDetails: (News) -> Unit) {
    val isExpanded = rememberSaveable {
        mutableStateOf(false)
    }
    Card(shape = RoundedCornerShape(8.dp), modifier = Modifier.padding(horizontal = 8.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = newsItem.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f)
            )
            Text(
                text = newsItem.title,
                modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp),
                style = MaterialTheme.typography.h6
            )
            Button(
                onClick = { isExpanded.value = !isExpanded.value },
                modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp)
            ) {
                val text = when (isExpanded.value) {
                    true -> R.string.home_button_collapse
                    false -> R.string.home_button_expand
                }.let { stringResource(id = it) }
                Text(text = text)
            }
            if (isExpanded.value) {
                Button(onClick = { onNavigateDetails.invoke(newsItem) }) {
                    Text(text = stringResource(id = R.string.home_button_details))
                }
            }
        }
    }

}