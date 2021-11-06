package com.shakbari.core.preferences

import android.content.Context
import android.content.SharedPreferences


class TokenPreferencesManager(context: Context) {
    private val pref: SharedPreferences by lazy { context.getSharedPreferences("manager", 0) }
    private val editor: SharedPreferences.Editor by lazy { pref.edit() }

    companion object {
        @JvmStatic
        private var instance: TokenPreferencesManager? = null
        private const val TOKEN = "token"

        @JvmStatic
        fun getInstance(context: Context): TokenPreferencesManager {
            if (instance == null) instance = TokenPreferencesManager(context)
            return instance as TokenPreferencesManager
        }
    }


    fun setToken(token: String) {
        editor.putString(TOKEN, token).commit()
    }

    fun getToken(): String {
       return pref.getString(TOKEN, "") ?: ""
    }

    fun deleteData() {
        editor.remove(TOKEN).apply()
        instance = null
    }
}