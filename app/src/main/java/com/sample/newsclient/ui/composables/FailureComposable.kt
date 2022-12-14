package com.sample.newsclient.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sample.newsclient.R

@Preview
@Composable
fun ErrorMessagePreview() {
    ErrorBox {}
}

@Composable
fun ErrorBox(onRetry: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = stringResource(id = R.string.error_generic))
            Button(onClick = onRetry) {
                Text(text = stringResource(id = R.string.error_button_try_again))
            }
        }
    }
}