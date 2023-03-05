package com.example.qiitaapp.domain.repository

import com.example.qiitaapp.domain.Article

interface ArticleRepository {
    fun list(): List<Article>
}