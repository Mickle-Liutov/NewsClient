package com.sample.newsclient.core

import java.lang.Exception

sealed interface ScreenState<out T>

data class Content<out T>(val content: T) : ScreenState<T>
object Progress : ScreenState<Nothing>
data class Failure(val exception: Exception) : ScreenState<Nothing>