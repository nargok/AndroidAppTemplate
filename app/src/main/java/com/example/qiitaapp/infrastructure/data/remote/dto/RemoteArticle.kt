package com.example.qiitaapp.infrastructure.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RemoteArticle(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("user")
    val user: User,
) {

    data class User(
        @SerializedName("id")
        val id: String,
        @SerializedName("profile_image_url")
        val profileImageUrl: String?
    )
}
