package com.example.qiitaapp.domain.repository

import com.example.qiitaapp.domain.model.Article
import com.example.qiitaapp.domain.model.vo.ArticleId

interface ArticleRepository {
    suspend fun list(): List<Article>

    suspend fun find(id: ArticleId): Article?
}