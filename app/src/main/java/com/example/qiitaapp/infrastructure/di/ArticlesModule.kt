package com.example.qiitaapp.infrastructure.di

import com.example.qiitaapp.infrastructure.data.remote.ArticleApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ArticlesModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .baseUrl(
                "https://qiita.com/"
            )
            .build()
    }

    @Provides
    fun provideRetrofitApi(retrofit: Retrofit): ArticleApiService {
        return retrofit.create(ArticleApiService::class.java)
    }

}