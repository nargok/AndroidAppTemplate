package com.example.qiitaapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.qiitaapp.domain.Article

val article1 = Article("1", "kotlin")
val article2 = Article("2", "React")
val articleList: List<Article> = mutableListOf<Article>(article1, article2)

class ArticlesViewModel : ViewModel() {

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
        _state.value = _state.value.copy(
            articles = articleList,
            isLoading = false
        )
    }
}