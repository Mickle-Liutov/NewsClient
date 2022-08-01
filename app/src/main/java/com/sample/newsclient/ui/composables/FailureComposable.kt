package com.sample.newsclient.ui.composables

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorMessage(e: Exception) {
    Text(text = e.message.orEmpty())
}