package com.example.core.session.impl

import com.example.core.session.api.SessionRepository
import com.example.core.session.api.SessionState
import com.example.core.session.api.TokenManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor(
    private val tokenManager: TokenManager
) : SessionRepository {

    private val mutableSessionState = MutableStateFlow(
        if (tokenManager.hasSession()) SessionState.Authorized else SessionState.Unauthorized
    )

    override val sessionState: Flow<SessionState> = mutableSessionState.asStateFlow()

    override suspend fun saveTokens(access: String, refresh: String) {
        tokenManager.saveTokens(access, refresh)
        mutableSessionState.value = SessionState.Authorized
    }

    override suspend fun clear() {
        tokenManager.clearSession()
        mutableSessionState.value = SessionState.Unauthorized
    }
}
