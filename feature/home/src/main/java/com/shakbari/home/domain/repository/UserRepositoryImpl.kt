package com.shakbari.home.domain.repository

import com.shakbari.core.base.DataState
import com.shakbari.home.common.api.HomeApiHelper
import com.shakbari.home.domain.entity.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val retrofitApiHelper: HomeApiHelper
) : UserRepository {

    override suspend fun getUsers(): ArrayList<User> = retrofitApiHelper.getUsers()



/*    override suspend fun getUsers(): Flow<DataState<ArrayList<User>>> = flow{
        try {
            val response = retrofitApiHelper.getUsers()
            emit(DataState.Success(response))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }*/
}