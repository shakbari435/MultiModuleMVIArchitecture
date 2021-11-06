package com.shakbari.core.di


import android.content.Context
import com.google.gson.GsonBuilder
import com.shakbari.core.di.utils.RetrofitConfig

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    fun provideUtils(@ApplicationContext appContext: Context) = RetrofitConfig(appContext)


    @Provides
    @Singleton
    fun provideOkHttpClient(
            retrofitUtils: RetrofitConfig
    ): OkHttpClient = OkHttpClient.Builder()
            .readTimeout(retrofitUtils.timeOut, TimeUnit.SECONDS)
            .connectTimeout(retrofitUtils.timeOut, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", retrofitUtils.token)
                        .build()
                chain.proceed(newRequest)
            }
            .build()



    @Provides
    @Singleton
    fun provideRetrofit(
             okHttpClient: OkHttpClient,retrofitUtils: RetrofitConfig
    ): Retrofit = Retrofit.Builder()
            .baseUrl(retrofitUtils.url)
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()

}