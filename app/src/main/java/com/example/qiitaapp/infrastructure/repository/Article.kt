package com.example.qiitaapp.infrastructure.repository

import com.example.qiitaapp.domain.Article
import com.example.qiitaapp.domain.repository.ArticleRepository
import com.example.qiitaapp.infrastructure.data.remote.ArticleApiService
import javax.inject.Inject
import javax.inject.Singleton

val article1 = Article("1", "kotlin")
val article2 = Article("2", "React")
val articleList: List<Article> = mutableListOf<Article>(article1, article2)

@Singleton
class ArticleRepositoryImpl @Inject constructor(
    private val restInterface: ArticleApiService
): ArticleRepository {

    override fun list(): List<Article> {
        return articleList
    }

}