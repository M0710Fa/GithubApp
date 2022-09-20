package com.example.githubapp.model.source.remote

interface RemoteDataSource {
    suspend fun fetchGithubUser(userName: String): GithubUser
}