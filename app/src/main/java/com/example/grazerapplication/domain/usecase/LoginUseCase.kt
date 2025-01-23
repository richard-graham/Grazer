package com.example.grazerapplication.domain.usecase

import com.example.grazerapplication.data.respository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): Result<String> =
        repository.login(email, password)
}