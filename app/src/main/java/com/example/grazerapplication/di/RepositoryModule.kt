package com.example.grazerapplication.di

import com.example.grazerapplication.data.respository.AuthRepository
import com.example.grazerapplication.data.respository.AuthRepositoryImpl
import com.example.grazerapplication.data.respository.UserRepository
import com.example.grazerapplication.data.respository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository
}