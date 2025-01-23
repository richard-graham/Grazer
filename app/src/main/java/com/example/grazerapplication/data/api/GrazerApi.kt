package com.example.grazerapplication.data.api

import com.example.grazerapplication.data.model.AuthRequest
import com.example.grazerapplication.data.model.AuthResponse
import com.example.grazerapplication.data.model.UsersResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface GrazerApi {
    @POST("v1/auth/login")
    suspend fun login(@Body request: AuthRequest): AuthResponse

    @GET("v1/users")
    suspend fun getUsers(@Header("Authorization") token: String): UsersResponse
}