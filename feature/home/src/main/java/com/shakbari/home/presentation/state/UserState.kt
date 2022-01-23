package com.shakbari.home.presentation.state

import com.shakbari.home.domain.entity.User

sealed class UserState {
    object Idle : UserState()
    object Loading : UserState()
    data class Users(val users: List<User>) : UserState()
    data class Error(val errorMessage: String?) : UserState()
    data class Empty(val emptyMessage: String?) : UserState()
}