package com.sample.newsclient.details

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.newsclient.core.*
import com.sample.newsclient.data.models.News
import com.sample.newsclient.navigation.NavigationArgs.NAV_ARG_NEWS_ID
import com.sample.newsclient.usecases.FetchNewsDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val fetchNewsDetails: FetchNewsDetailsUseCase
) : ViewModel() {

    private val newsId = savedStateHandle.get<Int>(NAV_ARG_NEWS_ID)!!

    private val _screenState = MutableStateFlow<ScreenState<News>>(Progress)
    val screenState = _screenState.asStateFlow()

    init {
        loadNewsDetails()
    }

    private fun loadNewsDetails() {
        viewModelScope.launchCatching(catch = {
            _screenState.value = Failure(it)
        }) {
            _screenState.value = Content(fetchNewsDetails.invoke())
        }
    }

}