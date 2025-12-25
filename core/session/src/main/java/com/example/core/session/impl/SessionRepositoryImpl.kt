package com.example.core.session.impl

import android.net.VpnService
import com.example.core.session.api.AuthState
import com.example.core.session.api.SessionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject


internal class SessionRepositoryImpl @Inject constructor() : SessionRepository {

    override val authState: Flow<AuthState> = flowOf(AuthState.Unauthorized)

    override suspend fun saveTokens(access: String, refresh: String) {
        TODO("Not yet implemented")
    }

    override suspend fun clear() {
        TODO("Not yet implemented")
    }

    fun forEach(list: List<Int>, action: (Int) -> Unit) {
        for (i in list) action(i)
    }
}