package com.example.qiitaapp.domain.model

import com.example.qiitaapp.domain.model.vo.ArticleId

data class Article(
    val id: ArticleId,
    val title: String,
    val body: String?,
    val htmlContent: String?,
    val author: Author
) {
    data class Author(
        val id: String,
        val profileImageUrl: String?
    )
}
