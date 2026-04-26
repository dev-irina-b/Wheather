package com.example.auth.domain

import javax.inject.Inject

class AuthUseCaseImpl @Inject constructor(private val authRepository: AuthRepository): AuthUseCase {
    override suspend fun invoke() {
        authRepository.login()
    }
}
