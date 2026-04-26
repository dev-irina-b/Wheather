package com.example.auth.data

interface AuthRemoteDataSource {

    suspend fun login()
}