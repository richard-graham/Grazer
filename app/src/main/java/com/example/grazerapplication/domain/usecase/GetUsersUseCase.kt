package com.example.grazerapplication.domain.usecase

import com.example.grazerapplication.data.model.User
import com.example.grazerapplication.data.respository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(): Result<List<User>> =
        repository.getUsers()
}