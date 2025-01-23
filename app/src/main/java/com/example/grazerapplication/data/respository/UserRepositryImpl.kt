package com.example.grazerapplication.data.respository

import com.example.grazerapplication.data.TokenManager
import com.example.grazerapplication.data.api.GrazerApi
import com.example.grazerapplication.data.model.User
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: GrazerApi,
    private val tokenManager: TokenManager
) : UserRepository {
    override suspend fun getUsers(): Result<List<User>> =
        try {
            val token = tokenManager.getToken() ?: throw IllegalStateException("No token found")
            val response = api.getUsers("Bearer $token")
            Result.success(response.data.users)
        } catch (e: Exception) {
            Result.failure(e)
        }
}