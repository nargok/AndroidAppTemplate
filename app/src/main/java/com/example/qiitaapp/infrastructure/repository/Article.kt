package com.example.qiitaapp.infrastructure.repository

import com.example.qiitaapp.domain.model.Article
import com.example.qiitaapp.domain.model.vo.ArticleId
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
) : ArticleRepository {

    override suspend fun list(): List<Article> {
        return withContext(Dispatchers.IO) {
            val articleList = restInterface.getArticles().map {
                remoteArticleToModel(it)
            }
            return@withContext articleList
        }
    }

    override suspend fun find(id: ArticleId): Article? {
        return withContext(Dispatchers.IO) {
            restInterface.getArticle(id.value)?.let { remoteArticleToModel(it) }
        }
    }

    private fun remoteArticleToModel(param: RemoteArticle): Article {
        return Article(
            id = ArticleId(param.id),
            title = param.title,
            body = param.body,
            htmlContent = param.renderedBody,
            author = Article.Author(
                id = param.user.id,
                profileImageUrl = param.user.profileImageUrl,
            )
        )
    }
}