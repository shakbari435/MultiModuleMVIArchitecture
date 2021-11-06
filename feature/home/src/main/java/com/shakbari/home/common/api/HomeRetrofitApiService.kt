package com.shakbari.home.common.api

import com.shakbari.home.domain.entity.User
import retrofit2.http.GET

interface HomeRetrofitApiService {
    @GET("users")
    suspend fun getUsers(): ArrayList<User>
}