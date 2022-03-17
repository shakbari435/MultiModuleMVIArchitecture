package com.shakbari.home.presentation.state

import androidx.paging.PagingData
import com.shakbari.home.domain.entity.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

sealed class UserState {
    object Idle : UserState()
    object Loading : UserState()
    data class Users(val users: MutableStateFlow<PagingData<User>>) : UserState()
    data class Error(val errorMessage: String?) : UserState()
    data class Empty(val emptyMessage: String?) : UserState()
}