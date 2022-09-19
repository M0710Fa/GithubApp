package com.example.githubapp.model.repository

data class User(
    val userId: UserId,
    val name: String,
    val avatarUrl: ImageUrl,
    val htmlUrl: HtmlUrl,
)

data class UserId(
    val value: Long
)

data class ImageUrl(
    val value: String
)

data class HtmlUrl(
    val value: String
)