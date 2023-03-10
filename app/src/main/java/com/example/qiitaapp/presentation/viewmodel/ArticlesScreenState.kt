package com.example.qiitaapp.presentation.viewmodel

import com.example.qiitaapp.domain.model.Article

data class ArticlesScreenState(
    val articles: List<Article>,
    val isLoading: Boolean,
    val error: String? = null
)
