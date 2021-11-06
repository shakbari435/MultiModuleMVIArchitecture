package com.shakbari.home.domain.usecase

import com.shakbari.core.base.DataState
import com.shakbari.home.domain.repository.UserRepository
import com.shakbari.home.domain.entity.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend fun getUsers(): Flow<DataState<ArrayList<User>>> =
        userRepository.getUsers()
}