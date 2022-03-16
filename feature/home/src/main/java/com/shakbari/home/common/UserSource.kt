package com.shakbari.home.common

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shakbari.home.domain.entity.User
import com.shakbari.home.domain.repository.UserRepository
import com.shakbari.home.domain.usecase.UserUseCase
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UserSource  @Inject constructor(
    private val repository: UserRepository,
) : PagingSource<Int, User>() {

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        return try {
            val nextPage = params.key ?: 1
            val userList = repository.getUsers()
            LoadResult.Page(
                data = userList,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage.plus(1)
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}