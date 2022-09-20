package com.example.githubapp.model.repository

interface UserRepository {
    suspend fun getUser(userName: String): User
}