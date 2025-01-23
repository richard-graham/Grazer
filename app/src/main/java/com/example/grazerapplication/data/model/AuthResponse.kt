package com.example.grazerapplication.data.model

data class AuthResponse(
    val status: Int,
    val status_desc: String,
    val auth: Auth
) {
    data class Auth(
        val data: AuthData
    ) {
        data class AuthData(
            val token: String
        )
    }
}