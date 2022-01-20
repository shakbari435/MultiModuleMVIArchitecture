package com.shakbari.home.presentation.state

import com.shakbari.home.domain.entity.User

data class UserListState(
    val isLoading: Boolean = false,
    val users : List<User> = ArrayList(),
    val isError : Boolean = false,
    val isEmpty : Boolean = false,
)
