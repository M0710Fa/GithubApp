package com.example.network.remote

import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val githubService: GithubService
): RemoteDataSource {
    override suspend fun fetchGithubUser(userName: String): GithubUser {
        val response = githubService.fetchGithubUser(userName = userName)
        if (response.isSuccessful){
            return response.body()?: error("Null Data")
        }
        throw HttpException()
    }
}

class HttpException: Throwable()