package com.shakbari.home.presentation.viewmodel


import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.shakbari.core.base.mvi.BaseViewModel
import com.shakbari.core.base.DataState
import com.shakbari.home.domain.entity.User
import com.shakbari.home.domain.usecase.UserUseCase
import com.shakbari.home.presentation.contract.HomeContract
import com.shakbari.home.presentation.pagination.UserSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val userUseCase: UserUseCase,
    private val userSource: UserSource
) : BaseViewModel<HomeContract.Intent, HomeContract.ScreenState/*, HomeContract.Effect*/>() {

    private val _users = MutableStateFlow<PagingData<User>>(PagingData.empty())


    override fun createInitialState(): HomeContract.ScreenState {
        return HomeContract.ScreenState.Idle
    }

    override fun handleIntent(intent: HomeContract.Intent) {
        when (intent) {
            is HomeContract.Intent.GetUsers -> getUsers()
            is HomeContract.Intent.GetUsersWithPaging -> getUsersWithPaging()
        }
    }

    private fun getUsers() {
        userUseCase().onEach {
            when (it) {
                is DataState.Error -> setState {
                    HomeContract.ScreenState.SideEffect(
                        HomeContract.SideEffect.ShowError("")
                    )
                }
                is DataState.Loading -> setState {
                    HomeContract.ScreenState.Users(
                        HomeContract.UsersState.Loading
                    )
                }
                is DataState.Success -> {
                    if (!it.data.isNullOrEmpty()) setState {
                        HomeContract.ScreenState.Users(
                            HomeContract.UsersState.Success(it.data)
                        )
                    }
                    else setState {
                        HomeContract.ScreenState.Users(
                            HomeContract.UsersState.Empty("Ops...List is Empty")
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }


    private fun getUsersWithPaging() {
        viewModelScope.launch {
            getUserSource().flow.cachedIn(viewModelScope).catch {
                setState {
                    HomeContract.ScreenState.SideEffect(
                        HomeContract.SideEffect.ShowError("")
                    )
                }
            }.collect {
                _users.value = it
                setState {
                    HomeContract.ScreenState.Users(
                        HomeContract.UsersState.SuccessPaging(_users)
                    )
                }
            }
        }
    }

    private fun getUserSource(): Pager<Int, User> {
        return Pager(PagingConfig(1)) {
            userSource
        }
    }


}