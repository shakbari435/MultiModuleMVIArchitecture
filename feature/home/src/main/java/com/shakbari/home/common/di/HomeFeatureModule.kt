package com.shakbari.home.common.di


import com.shakbari.home.common.api.HomeApiHelper
import com.shakbari.home.common.api.HomeApiHelperImpl
import com.shakbari.home.common.api.HomeRetrofitApiService
import com.shakbari.home.domain.repository.UserRepository
import com.shakbari.home.domain.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeFeatureModule {


    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): HomeRetrofitApiService = retrofit.create(HomeRetrofitApiService::class.java)

    @Singleton
    @Provides
    fun provideApiHelper(apiHelper: HomeApiHelperImpl): HomeApiHelper = apiHelper

    @Singleton
    @Provides
    fun provideUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository = userRepositoryImpl

}