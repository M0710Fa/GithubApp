package com.example.githubapp.model.source.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{username}")
    suspend fun fetchGithubUser(@Path("username") userName:String): Response<GithubUser>
}