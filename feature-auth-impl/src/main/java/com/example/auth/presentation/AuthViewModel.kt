package com.example.auth.presentation

import androidx.lifecycle.viewModelScope
import com.example.auth.domain.AuthUseCase
import com.example.auth.presentation.effect.AuthEffect
import com.example.auth.presentation.intent.AuthIntent
import com.example.auth.presentation.state.AuthUiState
import com.example.common.ui.base.BaseViewModel
import com.example.core.session.api.SessionRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val sessionRepository: SessionRepository
) : BaseViewModel<AuthUiState>(AuthUiState()) {

    private val _effect = MutableSharedFlow<AuthEffect>()
    val effect = _effect.asSharedFlow()

    fun handleIntent(intent: AuthIntent) {
        when (intent) {
            is AuthIntent.EmailChanged -> updateState { it.copy(email = intent.value) }
            is AuthIntent.PasswordChanged -> updateState { it.copy(password = intent.value) }
            AuthIntent.LoginClicked -> login()
        }
    }

    private fun login() = viewModelScope.launch {
        updateState { it.copy(isLoading = true, error = null) }

        runCatching {
            authUseCase()
            sessionRepository.saveTokens(
                access = "demo-access-token",
                refresh = "demo-refresh-token"
            )
        }.onSuccess {
            updateState { it.copy(isLoading = false) }
            _effect.emit(AuthEffect.NavigateHome)
        }.onFailure {
            updateState { it.copy(isLoading = false, error = "Login failed") }
            _effect.emit(AuthEffect.ShowMessage("Login failed"))
        }
    }
}
