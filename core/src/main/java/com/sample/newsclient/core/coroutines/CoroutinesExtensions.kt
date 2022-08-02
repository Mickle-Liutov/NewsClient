package com.sample.newsclient.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun CoroutineScope.launchCatching(catch: (Exception) -> Unit = {}, block: suspend () -> Unit): Job {
    return launch {
        try {
            block.invoke()
        } catch (e: Exception) {
            catch.invoke(e)
        }
    }
}