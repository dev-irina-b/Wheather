package com.example.core.session.api

sealed interface AuthState {
    data object Authorized: AuthState
    data object Unauthorized: AuthState
}