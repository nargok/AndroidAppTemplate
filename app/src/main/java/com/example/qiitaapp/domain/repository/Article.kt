package com.example.qiitaapp.domain.repository

import com.example.qiitaapp.domain.Article

interface ArticleRepository {
    suspend fun list(): List<Article>
}