package com.example.grazerapplication.data.respository

import com.example.grazerapplication.data.model.User

interface UserRepository {
    suspend fun getUsers(): Result<List<User>>
}