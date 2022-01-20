package com.shakbari.home.domain.usecase

import com.shakbari.core.base.DataState
import com.shakbari.home.domain.repository.UserRepository
import com.shakbari.home.domain.entity.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class UserUseCase @Inject constructor(private val userRepository: UserRepository) {

    operator fun invoke(): Flow<DataState<ArrayList<User>>> = flow {
        emit(DataState.Loading)
        try {
            val response = userRepository.getUsers()
            emit(DataState.Success(response))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }


/*
    fun getUsers(): Flow<DataState<ArrayList<User>>> = flow{
        try {
            val response = userRepository.getUsers()
            emit(DataState.Success(response))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }*/

}