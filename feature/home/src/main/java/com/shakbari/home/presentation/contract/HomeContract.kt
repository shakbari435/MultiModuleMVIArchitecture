package com.shakbari.home.presentation.contract

import androidx.paging.PagingData
import com.shakbari.core.base.mvi.UiIntent
import com.shakbari.core.base.mvi.UiState
import com.shakbari.home.domain.entity.User
import kotlinx.coroutines.flow.MutableStateFlow

class HomeContract {
    sealed class Intent : UiIntent {
        object GetUsers : Intent()
        object GetUsersWithPaging : Intent()
    }

    sealed class ScreenState : UiState {
        object Idle : ScreenState()
        object Loading : ScreenState()
        data class Users(val userState: UsersState) : ScreenState()
        data class SideEffect(val sideEffect: HomeContract.SideEffect) : ScreenState()
    }


    sealed class UsersState {
        object Loading : UsersState()
        data class Success(val users : MutableStateFlow<MutableList<User>>) : UsersState()
        //data class SuccessPaging(val users: MutableStateFlow<PagingData<User>>) : UsersState()
        data class Error(val errorMessage: String?) : UsersState()
        data class Empty(val emptyMessage: String?) : UsersState()
    }


    sealed class SideEffect  {
        data class ShowError(val message : String?) : SideEffect()
    }
}