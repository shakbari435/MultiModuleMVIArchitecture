package com.shakbari.home.common.api

import com.shakbari.home.domain.entity.User

interface HomeApiHelper {
    suspend fun getUsers(): ArrayList<User>
}