package com.example.auth.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.auth.R

@Composable
fun AuthScreen(
    modifier: Modifier = Modifier,
    onLoginSuccess: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Image(
            painter = painterResource(id =
            R.drawable.ic_weather_illustration),
            contentDescription = null)
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 48.dp),
            text = "Войдите или зарегистрируйтесь",
            fontSize = 24.sp,
            color = Color.DarkGray
        )
        Spacer(modifier = modifier.height(24.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            label = { Text("Email") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            label = { Text("password") })
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            modifier = Modifier
                .padding(horizontal = 36.dp)
                .fillMaxWidth(),
            enabled = true,
            onClick = {
                isLoading = true
            },
        ) {
            if (isLoading) {
                CircularProgressIndicator()
            } else Text("Войти")
        }
        Button(
            modifier = Modifier
                .padding(horizontal = 36.dp)
                .fillMaxWidth(),
            enabled = true,
            onClick = {
                isLoading = true
            },
        ) {
            if (isLoading) {
                CircularProgressIndicator()
            } else Text("Зарегистрироваться")
        }
    }
}

@Preview
@Composable
fun AuthScreenPreview() {
    AuthScreen()
}