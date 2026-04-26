package com.example.auth.data

import com.example.auth.domain.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
    override suspend fun login() {
        authRemoteDataSource.login()
    }
}
