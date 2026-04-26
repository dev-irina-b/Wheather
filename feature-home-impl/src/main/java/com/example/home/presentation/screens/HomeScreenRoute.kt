package com.example.home.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.common.ui.LocalViewModelFactory
import com.example.home.presentation.states.HomeUiState
import com.example.home.presentation.viewmodels.HomeViewModel

@Composable
fun HomeScreenRoute(modifier: Modifier = Modifier) {
    val viewModelFactory = LocalViewModelFactory.current
    val viewModel: HomeViewModel = viewModel(factory = viewModelFactory)
    val uiState = viewModel.state.collectAsStateWithLifecycle()

    HomeScreen(
        uiState = uiState.value,
        modifier = modifier,
        onRefresh = viewModel::getWeather
    )
}

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    modifier: Modifier = Modifier,
    onRefresh: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(horizontal = 24.dp, vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Home weather",
            fontSize = 24.sp,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(24.dp))

        when (uiState) {
            HomeUiState.Loading -> CircularProgressIndicator()
            is HomeUiState.Success -> {
                Text("Latitude: ${uiState.weatherData.latitude}")
                Spacer(modifier = Modifier.height(8.dp))
                Text("Longitude: ${uiState.weatherData.longitude}")
            }
            is HomeUiState.Error -> {
                Text(
                    text = uiState.message,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onRefresh
        ) {
            Text("Refresh")
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(uiState = HomeUiState.Loading)
}
