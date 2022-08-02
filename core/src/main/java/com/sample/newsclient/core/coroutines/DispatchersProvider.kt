package com.sample.newsclient.core.coroutines

import kotlinx.coroutines.CoroutineDispatcher

class DispatchersProvider(
    mainDispatcher: CoroutineDispatcher,
    ioDispatcher: CoroutineDispatcher,
    defaultDispatcher: CoroutineDispatcher,
) {
    val main = mainDispatcher
    val io = ioDispatcher
    val default = defaultDispatcher
}