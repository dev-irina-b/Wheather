package com.example.auth.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.auth.R
import com.example.auth.presentation.AuthViewModel
import com.example.auth.presentation.effect.AuthEffect
import com.example.auth.presentation.intent.AuthIntent
import com.example.auth.presentation.state.AuthUiState
import com.example.common.ui.LocalViewModelFactory
import com.example.core_navigation.Navigator

@Composable
fun AuthRoute(
    navigator: Navigator
) {
    val viewModelFactory = LocalViewModelFactory.current
    val viewModel: AuthViewModel = viewModel(factory = viewModelFactory)
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                AuthEffect.NavigateHome -> {}
                is AuthEffect.ShowMessage -> Unit
            }
        }
    }

    AuthContent(
        uiState = uiState,
        onEmailChanged = { viewModel.handleIntent(AuthIntent.EmailChanged(it)) },
        onPasswordChanged = { viewModel.handleIntent(AuthIntent.PasswordChanged(it)) },
        onLoginClick = { viewModel.handleIntent(AuthIntent.LoginClicked) }
    )
}

@Composable
fun AuthContent(
    uiState: AuthUiState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF80D0FF),
                        Color(0xFFEAF6FF)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_weather_illustration),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
            )

            Spacer(Modifier.height(16.dp))

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = stringResource(id = R.string.auth_title),
                fontSize = 24.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = uiState.email,
                onValueChange = onEmailChanged,
                label = { Text("Email") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = uiState.password,
                onValueChange = onPasswordChanged,
                label = { Text("Password") }
            )

            Spacer(modifier = Modifier.height(24.dp))

            uiState.error?.let { error ->
                Text(text = error, color = Color.Red)
                Spacer(modifier = Modifier.height(12.dp))
            }

            Button(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                enabled = !uiState.isLoading,
                onClick = onLoginClick,
            ) {
                if (uiState.isLoading) {
                    CircularProgressIndicator()
                } else {
                    Text("Sign in")
                }
            }
        }
    }
}

@Preview
@Composable
fun AuthScreenPreview() {
    AuthContent(
        uiState = AuthUiState(),
        onEmailChanged = {},
        onPasswordChanged = {},
        onLoginClick = {}
    )
}
