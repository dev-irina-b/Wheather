package com.example.splash.presentation.screen

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.common.ui.LocalViewModelFactory
import com.example.splash.R
import com.example.splash.presentation.SplashDestination
import com.example.splash.presentation.SplashViewModel
import kotlinx.coroutines.delay

@Composable
internal fun SplashRoute(
    onAuthorized: () -> Unit,
    onUnauthorized: () -> Unit
) {
    val viewModelFactory = LocalViewModelFactory.current

    val viewModel: SplashViewModel = viewModel(factory = viewModelFactory)
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(state.destination) {

        when (state.destination) {
            is SplashDestination.Home -> onAuthorized()
            is SplashDestination.Auth -> onUnauthorized()
            null -> Unit
        }
    }

    SplashContent()
}

@Composable
fun SplashContent() {
    var startAnimation by remember { mutableStateOf(false) }

    val cloudOffset by animateDpAsState(
        targetValue = if (startAnimation) (-120).dp else 0.dp,
        animationSpec = tween(
            durationMillis = 400,
            easing = FastOutSlowInEasing
        ),
        label = "cloudOffset"
    )

    val sunAlfa by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0.7f,
        animationSpec = tween(
            durationMillis = 400,
            easing = FastOutSlowInEasing
        ),
        label = "sunAlfa"
    )

    val sunScale by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0.7f,
        animationSpec = tween(
            durationMillis = 400,
            easing = FastOutSlowInEasing
        ),
        label = "sunScale"
    )

    LaunchedEffect(Unit) {
        delay(150)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.splash_sun_image
            ),
            contentDescription = null,
            modifier = Modifier.graphicsLayer {
                alpha = sunAlfa
                scaleX = sunScale
                scaleY = sunScale
            }
        )
        Image(
            painter = painterResource(
                id = R.drawable.splash_cloud_image
            ),
            contentDescription = null,
            modifier = Modifier.offset(x = cloudOffset)
        )
        Text(
            text = "Weather App",
            fontSize = 24.sp,
            color = Color(0xFF5A3E2B),
            modifier = Modifier.offset(y = 50.dp)
        )
    }
}

@Preview
@Composable
fun SplashContentPreview() {
    SplashContent()
}
