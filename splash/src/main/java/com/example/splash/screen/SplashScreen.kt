package com.example.splash.screen

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun SplashScreen() {

    var visible by remember { mutableStateOf(false) }

    val alpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(durationMillis = 1200),
        label = "fade"
    )

    val scale by animateFloatAsState(
        targetValue = if (visible) 1f else 0.7f,
        animationSpec = tween(
            durationMillis = 1200,
            easing = FastOutSlowInEasing
        ),
        label = "scale"
    )

    LaunchedEffect(Unit) {
        visible = true
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    )  {
        Text(modifier = Modifier
            .graphicsLayer {
                this.alpha = alpha
                this.scaleX = scale
                this.scaleY = scale
            },
            text = "Your weather",
            color = Color.DarkGray,
            fontSize = 42.sp
        )

    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}