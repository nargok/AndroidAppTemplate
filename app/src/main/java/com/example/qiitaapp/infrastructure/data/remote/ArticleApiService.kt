package com.example.qiitaapp.infrastructure.data.remote

import com.example.qiitaapp.infrastructure.data.remote.dto.RemoteArticle
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArticleApiService {
    @GET("api/v2/items")
    suspend fun getArticles(): List<RemoteArticle>

    @GET("api/v2/items/{id}")
    suspend fun getArticle(@Path("id") id: String): RemoteArticle?
}