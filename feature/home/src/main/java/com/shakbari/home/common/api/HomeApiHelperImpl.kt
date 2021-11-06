package com.shakbari.home.common.api

import com.shakbari.home.domain.entity.User
import javax.inject.Inject

class HomeApiHelperImpl @Inject constructor(private val apiService: HomeRetrofitApiService): HomeApiHelper {

    override suspend fun getUsers(): ArrayList<User>  = apiService.getUsers()

}