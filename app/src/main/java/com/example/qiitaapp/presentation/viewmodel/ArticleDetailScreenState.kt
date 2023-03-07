package com.example.qiitaapp.presentation.viewmodel

import com.example.qiitaapp.domain.model.Article

data class ArticleDetailScreenState(
    var article: Article?,
    val isLoading: Boolean,
    val error: String? = null
)
