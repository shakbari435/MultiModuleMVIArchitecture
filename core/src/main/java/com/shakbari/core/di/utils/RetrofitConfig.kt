package com.shakbari.core.di.utils

import android.content.Context
import com.shakbari.core.preferences.TokenPreferencesManager

class RetrofitConfig(context: Context) {
    var url: String = "https://5e510330f2c0d300147c034c.mockapi.io/"
    var timeOut: Long = 30L
    var token: String = "Bearer ${TokenPreferencesManager.getInstance(context).getToken()}"
}

