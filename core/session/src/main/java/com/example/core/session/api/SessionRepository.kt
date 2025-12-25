package com.example.core.session.api

import kotlinx.coroutines.flow.Flow

interface SessionRepository {
    val authState: Flow<AuthState>
    suspend fun saveTokens(access: String, refresh: String)
    suspend fun clear()
}