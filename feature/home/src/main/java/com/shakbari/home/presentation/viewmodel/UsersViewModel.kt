package com.shakbari.home.presentation.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.shakbari.home.presentation.pagination.UserSource
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

    private val _users = MutableStateFlow<PagingData<User>>(PagingData.empty())


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
                }
            }
        }
    }

/*    private fun getUsers() {
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
    }*/


    suspend fun getUsers() {
        viewModelScope.launch {
            getUserSource().flow.cachedIn(viewModelScope).catch {
                updateState(UserState.Error(""))
            }.collect {
                _users.value = it
                updateState(UserState.Users(_users))
            }
        }
    }

    private fun getUserSource(): Pager<Int, User> {
        return Pager(PagingConfig(5)) {
            userSource
        }
    }
}