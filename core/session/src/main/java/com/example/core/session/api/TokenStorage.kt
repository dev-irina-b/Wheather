package com.example.core.session.api

interface TokenStorage {

    fun getAccessToken(): String?

    fun getRefreshToken(): String?

    fun saveAccessToken(token: String)

    fun saveRefreshToken(token: String)

    fun clear()
}
