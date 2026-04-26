package com.example.core.session.data

import android.content.SharedPreferences
import com.example.core.session.api.TokenStorage
import javax.inject.Inject

class TokenStorageImpl @Inject constructor(
    private val prefs: SharedPreferences
): TokenStorage {
    override fun getAccessToken(): String? =
        prefs.getString(KEY_ACCESS, null)

    override fun getRefreshToken(): String? =
        prefs.getString(KEY_REFRESH, null)

    override fun saveAccessToken(token: String) {
        prefs.edit().putString(KEY_ACCESS, token).apply()
    }

    override fun saveRefreshToken(token: String) {
        prefs.edit().putString(KEY_REFRESH, token).apply()
    }

    override fun clear() {
        prefs.edit().clear().apply()
    }

    private companion object {
        const val KEY_ACCESS = "access_token"
        const val KEY_REFRESH = "refresh_token"
    }
}
