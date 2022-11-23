package com.example.network.remote

interface RemoteDataSource {
    suspend fun fetchGithubUser(userName: String): GithubUser
}