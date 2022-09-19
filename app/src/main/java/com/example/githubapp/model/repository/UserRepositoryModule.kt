package com.example.githubapp.model.repository

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UserRepositoryModule {
    fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository{
        return userRepositoryImpl
    }
}