package com.example.grazerapplication.presentation.users

import com.example.grazerapplication.data.model.User


sealed class UsersUiState {
    data object Loading : UsersUiState()
    data class Success(val users: List<User>) : UsersUiState()
    data class Error(val message: String) : UsersUiState()
}