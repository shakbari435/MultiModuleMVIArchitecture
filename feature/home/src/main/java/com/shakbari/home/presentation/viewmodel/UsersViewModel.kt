package com.shakbari.home.presentation.viewmodel


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.shakbari.core.base.mvi.BaseViewModel
import com.shakbari.core.base.DataState
import com.shakbari.home.domain.entity.User
import com.shakbari.home.domain.usecase.UserUseCase
import com.shakbari.home.presentation.contract.HomeContract
import com.shakbari.home.presentation.pagination.UserSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val userUseCase: UserUseCase,
    // private val userSource: UserSource
) : BaseViewModel<HomeContract.Intent, HomeContract.ScreenState/*, HomeContract.Effect*/>() {

    //private val _users = MutableStateFlow<PagingData<User>>(PagingData.empty())
    private val _users = MutableStateFlow<MutableList<User>>(ArrayList())
    var isLoadMoreLoading = mutableStateOf(false)

    override fun createInitialState(): HomeContract.ScreenState {
        return HomeContract.ScreenState.Idle
    }

    override fun handleIntent(intent: HomeContract.Intent) {
        when (intent) {
            is HomeContract.Intent.GetUsers -> getUsers()
        }
    }

    private fun getUsers() {
        if (_users.value.isNotEmpty()) {
            isLoadMoreLoading.value = true
        }
        userUseCase().onEach {
            when (it) {
                is DataState.Error -> {
                    if (_users.value.isEmpty()) {
                        setState {
                            HomeContract.ScreenState.SideEffect(
                                HomeContract.SideEffect.ShowError("")
                            )
                        }
                    }
                }

                is DataState.Loading -> {
                    if (_users.value.isEmpty()) {
                        setState {
                            HomeContract.ScreenState.Users(
                                HomeContract.UsersState.Loading
                            )
                        }
                    }
                }
                is DataState.Success -> {
                    if (!it.data.isNullOrEmpty()) {
                        _users.value.addAll(it.data)
                        isLoadMoreLoading.value = false
                        setState {
                            HomeContract.ScreenState.Users(
                                HomeContract.UsersState.Success(_users)
                            )
                        }
                    } else {
                        if (_users.value.isEmpty()) {
                            setState {
                                HomeContract.ScreenState.Users(
                                    HomeContract.UsersState.Empty("Ops...List is Empty")
                                )
                            }
                        }
                    }
                }
            }
        }.launchIn(viewModelScope)
    }



    /*   private fun getUsersWithPaging() {
           viewModelScope.launch {
               getUserSource().flow.cachedIn(viewModelScope).catch {
                   setState {
                       HomeContract.ScreenState.SideEffect(
                           HomeContract.SideEffect.ShowError("")
                       )
                   }
               }.collect {
                   //_users.value = it
                   setState {
                       HomeContract.ScreenState.Users(
                           HomeContract.UsersState.SuccessPaging(MutableStateFlow(it))
                       )
                   }
               }
           }
       }

       private fun getUserSource(): Pager<Int, User> {
           return Pager(PagingConfig(1)) {
               userSource
           }
       }*/


}