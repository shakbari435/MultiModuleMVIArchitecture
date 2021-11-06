package com.shakbari.core.base

sealed class ViewState<out R> {
    object Loading : ViewState<Nothing>()

    data class Success<out T>(val data: T, val message: String = "") : ViewState<T>()

    data class Empty(
        val message: String? = "There is Nothing to show"
    ) : ViewState<Nothing>()

    data class Error(
        val exception: Exception,
        val message: String? = "There is Nothing to show"
    ) : ViewState<Nothing>()

}