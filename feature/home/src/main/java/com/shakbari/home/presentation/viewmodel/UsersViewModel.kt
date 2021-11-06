package com.shakbari.home.presentation.viewmodel


import androidx.lifecycle.ViewModel
import com.shakbari.core.base.DataState
import com.shakbari.core.base.ViewState
import com.shakbari.home.domain.entity.User
import com.shakbari.home.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val userUseCase: UserUseCase
) : ViewModel() {
    fun getUsers(): Flow<ViewState<ArrayList<User>>> = flow {
        userUseCase.getUsers()
            .catch { println(it.message) }
            .collect {
                when (it) {
                    is DataState.Error -> emit(ViewState.Error(it.exception))
                    is DataState.Loading -> emit(ViewState.Loading)
                    is DataState.Success -> {
                        if (it.data.isNullOrEmpty())
                            emit(ViewState.Empty())
                        else
                            emit(ViewState.Success(it.data))
                    }
                }
            }
    }
}