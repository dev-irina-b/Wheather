package com.example.auth.presentation.intent

sealed interface AuthIntent {
    data class EmailChanged(val value: String) : AuthIntent
    data class PasswordChanged(val value: String) : AuthIntent
    data object LoginClicked : AuthIntent
}
