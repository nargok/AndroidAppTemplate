package com.example.qiitaapp.infrastructure.data.remote

import com.example.qiitaapp.infrastructure.data.remote.dto.RemoteArticle
import retrofit2.http.GET

interface ArticleApiService {
    @GET("api/v2/items")
    suspend fun getArticles(): List<RemoteArticle>
}