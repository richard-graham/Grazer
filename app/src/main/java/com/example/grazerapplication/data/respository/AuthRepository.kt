package com.example.grazerapplication.data.respository

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<String>
}