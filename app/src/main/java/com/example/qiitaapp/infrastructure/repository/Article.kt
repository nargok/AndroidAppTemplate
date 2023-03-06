package com.example.qiitaapp.infrastructure.repository

import com.example.qiitaapp.domain.Article
import com.example.qiitaapp.domain.repository.ArticleRepository
import com.example.qiitaapp.infrastructure.data.remote.ArticleApiService
import com.example.qiitaapp.infrastructure.data.remote.dto.RemoteArticle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepositoryImpl @Inject constructor(
    private val restInterface: ArticleApiService
): ArticleRepository {

    override suspend fun list(): List<Article> {
        return withContext(Dispatchers.IO) {
            val articleList = restInterface.getArticles().map {
                remoteArticleToModel(it)
            }
            return@withContext articleList
        }
    }

    private fun remoteArticleToModel(param: RemoteArticle): Article {
        return Article(
            id = param.id,
            title = param.title,
            user = Article.User(
                id = param.user.id,
                profileImageUrl = param.user.profileImageUrl,
            )
        )
    }
}