package com.shakbari.home.domain.repository

import com.shakbari.core.base.DataState
import com.shakbari.home.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUsers() : ArrayList<User>
}