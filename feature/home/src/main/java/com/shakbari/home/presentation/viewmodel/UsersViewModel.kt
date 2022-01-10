package com.shakbari.home.presentation.viewmodel


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.shakbari.core.base.DataState
import com.shakbari.core.base.Resource
import com.shakbari.core.base.UiState
import com.shakbari.core.base.ViewState
import com.shakbari.home.domain.entity.User
import com.shakbari.home.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val userUseCase: UserUseCase,
    ) : ViewModel() {
    val _uiState = MutableStateFlow(Resource)
    //val uiState: StateFlow<Resource> = _uiState.asStateFlow()


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
        fun getUsers2(): Flow<UiState> = flow {

        userUseCase.getUsers()
            .catch { println(it.message) }
            .collect {
                when (it) {
                    is DataState.Error -> emit(UiState.Error(it.exception))
                    is DataState.Loading -> emit(UiState.Loading)
                    is DataState.Success -> {
                        if (it.data.isNullOrEmpty())
                            emit(UiState.Empty())
                        else
                            emit(UiState.Success(it.data))
                    }
                }
            }
    }


    data class UserState(
        val recipes: List<User> = emptyList(),
        val isEmpty: Boolean = false
    )

}

