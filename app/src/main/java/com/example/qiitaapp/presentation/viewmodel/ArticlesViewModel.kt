package com.example.qiitaapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qiitaapp.application.ArticleViewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val articleViewUseCase: ArticleViewUseCase
) : ViewModel() {
    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
        _state.value = _state.value.copy(
            error = exception.message,
            isLoading =  false
        )
    }

    private val _state = mutableStateOf(
        ArticlesScreenState(
            articles = listOf(),
            isLoading = true
        )
    )

    val state: State<ArticlesScreenState> get() = _state

    init {
        getArticles()
    }

    private fun getArticles() {
        viewModelScope.launch(errorHandler) {
            _state.value = _state.value.copy(
                articles = articleViewUseCase.list(),
                isLoading = false
            )
        }
    }
}