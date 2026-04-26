package com.example.core.session.api

import kotlinx.coroutines.flow.Flow

interface SessionRepository {
    val sessionState: Flow<SessionState>
    suspend fun saveTokens(access: String, refresh: String)
    suspend fun clear()
}