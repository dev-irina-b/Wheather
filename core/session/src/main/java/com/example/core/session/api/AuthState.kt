package com.example.core.session.api

sealed interface SessionState {
    data object Authorized : SessionState
    data object Unauthorized : SessionState
    data object Loading : SessionState // пока читаем токен из DataStore
}
