package com.shakbari.compose

import android.app.Application
import com.shakbari.details.navigation.detailScreenNavModule
import com.shakbari.home.common.navigation.homeScreenNavModule
import com.shakbari.navigation.base.multiNavigationModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent

@HiltAndroidApp
@Module
@InstallIn(SingletonComponent::class)
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        multiNavigationModule(
            homeScreenNavModule,
            detailScreenNavModule
        )
    }
}