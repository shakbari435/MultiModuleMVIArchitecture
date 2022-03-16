package com.shakbari.home.presentation.intent

sealed class UsersIntent {
    object GetUsers : UsersIntent()
    object GetUsers2 : UsersIntent()

}