package com.shakbari.home.presentation.viewmodel


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shakbari.core.base.DataState
import com.shakbari.core.base.ViewState
import com.shakbari.home.domain.entity.User
import com.shakbari.home.domain.usecase.UserUseCase
import com.shakbari.home.presentation.state.UserListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val userUseCase: UserUseCase
) : ViewModel() {

    private val _state = mutableStateOf(UserListState())
    val userState: State<UserListState> = _state

    init {
        getUsers()
    }

    private fun getUsers() {
        userUseCase().onEach {
            when (it) {
                is DataState.Error -> _state.value = UserListState(isEmpty = true)
                is DataState.Loading -> _state.value = UserListState(isLoading = true)
                is DataState.Success -> {
                    if (it.data.isNullOrEmpty())
                        _state.value = UserListState(isEmpty = true)
                    else
                        _state.value = UserListState(users = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }


/*    fun getUsers2() {
        userUseCase.getUsers().onEach {
            when (it) {
                is DataState.Error -> _state.value = UserListState(isEmpty = true)
                is DataState.Loading -> _state.value = UserListState(isLoading = true)
                is DataState.Success -> {
                    if (it.data.isNullOrEmpty())
                        _state.value = UserListState(isEmpty = true)
                    else
                        _state.value = UserListState(users = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }*/

}