package com.shakbari.home.presentation.state

import androidx.paging.PagingData
import com.shakbari.home.domain.entity.User
import kotlinx.coroutines.flow.Flow

sealed class UserState {
    object Idle : UserState()
    object Loading : UserState()
    data class Users(val users: MutableList<User>) : UserState()
    data class Users2(val users: Flow<PagingData<User>>?) : UserState()
    data class Error(val errorMessage: String?) : UserState()
    data class Empty(val emptyMessage: String?) : UserState()
}