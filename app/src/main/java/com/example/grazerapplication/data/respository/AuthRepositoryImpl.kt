package com.example.grazerapplication.data.respository

import com.example.grazerapplication.data.TokenManager
import com.example.grazerapplication.data.api.GrazerApi
import com.example.grazerapplication.data.model.AuthRequest
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: GrazerApi,
    private val tokenManager: TokenManager
) : AuthRepository {
    override suspend fun login(email: String, password: String): Result<String> =
        try {
            val response = api.login(AuthRequest(email, password))
            val token = response.auth.data.token
            tokenManager.saveToken(token)
            Result.success(token)
        } catch (e: Exception) {
            Result.failure(e)
        }
}