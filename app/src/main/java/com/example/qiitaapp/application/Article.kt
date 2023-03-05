package com.example.qiitaapp.application

import com.example.qiitaapp.domain.Article
import com.example.qiitaapp.infrastructure.repository.ArticleRepositoryImpl
import javax.inject.Inject

class ArticleViewUseCase @Inject constructor(
    private val repository: ArticleRepositoryImpl
){
    suspend fun list(): List<Article>{
       return repository.list()
    }
}