package com.example.qiitaapp.domain

data class Article(
    val id: String,
    val title: String,
    val author: Author
) {
    data class Author(
        val id: String,
        val profileImageUrl: String?
    )
}

