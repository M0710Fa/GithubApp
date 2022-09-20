package com.example.githubapp.model.source.remote

data class GithubUser(
    val id: Long,
    val name: String,
    val avatar_url: String,
    val html_url: String,
)
