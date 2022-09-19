package com.example.githubapp.model.repository

import com.example.githubapp.model.source.remote.GithubUser
import com.example.githubapp.model.source.remote.RemoteDataSource
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): UserRepository {
    override suspend fun getUser(userName: String): User {
        return remoteDataSource.fetchGithubUser(userName = userName).toUser()
    }

    //GithubUserをUserに変換するための拡張関数
    private fun GithubUser.toUser():User{
        return User(
            userId = UserId(value = id),
            name = name,
            avatarUrl = ImageUrl(value = avatar_url),
            htmlUrl = HtmlUrl(value = html_url)
        )
    }
}