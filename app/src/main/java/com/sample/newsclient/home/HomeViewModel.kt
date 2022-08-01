package com.sample.newsclient.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.newsclient.core.*
import com.sample.newsclient.models.News
import com.sample.newsclient.usecases.FetchNewsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchNewsList: FetchNewsListUseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow<ScreenState<List<News>>>(Progress)
    val screenState = _screenState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launchCatching(catch = {
            _screenState.value = Failure(it)
        }) {
            _screenState.value = Content(fetchNewsList.invoke())
        }
    }

}