package com.shakbari.home.presentation.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LoadState
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingState
import com.shakbari.core.base.DataState
import com.shakbari.home.common.UserSource
import com.shakbari.home.domain.entity.User
import com.shakbari.home.domain.usecase.UserUseCase
import com.shakbari.home.presentation.intent.UsersIntent
import com.shakbari.home.presentation.state.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val userUseCase: UserUseCase,
    private val userSource: UserSource
) : ViewModel() {
    private val userIntent = Channel<UsersIntent>(Channel.UNLIMITED)
    private val _state = MutableStateFlow<UserState>(UserState.Idle)
    val state: StateFlow<UserState>
        get() = _state

    fun updateState(userState: UserState) {
        _state.value = userState
    }


    init {
        intentHandler()
    }

    fun sendIntent(usersIntent: UsersIntent) {
        viewModelScope.launch {
            userIntent.send(usersIntent)
        }
    }

    private fun intentHandler() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect {
                when (it) {
                    is UsersIntent.GetUsers -> getUsers()
                    is UsersIntent.GetUsers2 -> updateState(UserState.Users2(getUserSource().flow))
                }
            }
        }
    }

    private fun getUsers() {
        userUseCase().onEach {
            when (it) {
                is DataState.Error -> updateState(UserState.Error("${it.exception.message}"))
                is DataState.Loading -> updateState(UserState.Loading)
                is DataState.Success -> {
                    if (!it.data.isNullOrEmpty())
                        updateState(UserState.Users(it.data))
                    else
                        updateState(UserState.Empty("Ops...List is Empty"))
                }
            }
        }.launchIn(viewModelScope)
    }

    fun updateUser(users:ArrayList<User>){
        val userss = (_state.value as UserState.Users).users.apply {
            addAll(users)
        }
       _state.value = (_state.value as UserState.Users).copy(users = userss)
    }

/*    private fun getUser2(){
        getUserSource().flow.onEach {
            when (it) {
                is LoadState.Error -> updateState(UserState.Error("${it.exception.message}"))
                is DataState.Loading -> updateState(UserState.Loading)
                is DataState.Success -> {
                    if (!it.data.isNullOrEmpty())
                        updateState(UserState.Users(it.data))
                    else
                        updateState(UserState.Empty("Ops...List is Empty"))
                }
            }
        }.launchIn(viewModelScope)
    }*/

    private fun getUserSource(): Pager<Int, User> {
        return Pager(PagingConfig(5)) {
            userSource
        }
    }
}