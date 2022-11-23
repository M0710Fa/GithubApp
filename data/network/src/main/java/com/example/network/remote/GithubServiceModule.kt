package com.example.network.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GithubServiceModule {

    @Provides
    @Singleton
    fun provideGithubService(githubServiceProvider: GithubServiceProvider): GithubService {
        return githubServiceProvider.createGithubService()
    }
}