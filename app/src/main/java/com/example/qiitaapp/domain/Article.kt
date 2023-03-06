package com.example.qiitaapp.domain

data class Article(
    val id: String,
    val title: String,
    val user: User
) {
    data class User(
        val id: String,
        val profileImageUrl: String?
    )
}

