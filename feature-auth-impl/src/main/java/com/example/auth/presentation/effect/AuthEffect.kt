package com.example.auth.presentation.effect

sealed interface AuthEffect {
    data object NavigateHome : AuthEffect
    data class ShowMessage(val text: String) : AuthEffect
}
