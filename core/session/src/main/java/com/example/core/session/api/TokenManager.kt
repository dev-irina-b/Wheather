package com.example.core.session.api

import javax.inject.Inject

class TokenManager @Inject constructor(
    private val storage: TokenStorage
) {

    fun hasSession(): Boolean {
        return storage.getRefreshToken() != null
    }

    fun getAccessToken(): String? {
        return storage.getAccessToken()
    }

    fun saveTokens(access: String, refresh: String) {
        storage.saveAccessToken(access)
        storage.saveRefreshToken(refresh)
    }

    fun clearSession() {
        storage.clear()
    }
}