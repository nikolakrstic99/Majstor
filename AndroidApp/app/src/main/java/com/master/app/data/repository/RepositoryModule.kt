package com.master.app.data.repository

import com.master.app.data.source.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideBlogsRepository(apiService: ApiService): BlogsRepository =
        BlogsRepositoryImpl(apiService)

    @Provides
    @Singleton
    fun provideUserRepository(apiService: ApiService): UserRepository =
        UserRepositoryImpl(apiService)

    @Provides
    @Singleton
    fun provideRepairmentRepository(apiService: ApiService): RepairmentRepository =
        RepairmentRepositoryImpl(apiService)
}