package com.shakbari.core.base

sealed interface UiState {

    object Loading : UiState
    data class Success<out T>(val data: T, val message: String = "") : UiState
    data class Empty(
        val message: String? = "There is Nothing to show"
    ) : UiState

    data class Error(
        val exception: Exception,
        val message: String? = "There is Nothing to show"
    ) : UiState

}