package com.demo.amitav.mycompose.views.uiComponents

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CircularProgressBar {

    private var percentage: Float = 0.9f
    private var number: Int = 100
    private var radius: Dp = 50.dp
    private var strokewidth: Dp = 8.dp
    private var animDuration: Int = 2000
    private var animDelay: Int = 0

    @Composable
    fun CircularProgress() {
        var animationPlayed by remember {
            mutableStateOf(false)
        }

        val currentPercentage = animateFloatAsState(
            targetValue = if (animationPlayed) percentage else 0.0f,
            animationSpec = tween(
                durationMillis = animDuration,
                delayMillis = animDelay
            )
        )

        LaunchedEffect(key1 = true) {
            animationPlayed = true
        }

        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {
            Canvas(modifier = Modifier.size(radius * 2f)){
                drawArc(
                    color = Color.Blue,
                    startAngle = -90f,
                    sweepAngle = 360 * currentPercentage.value,
                    useCenter = false,
                    style = Stroke(strokewidth.toPx(), cap = StrokeCap.Square)
                )
            }
            Text(
                text = (currentPercentage.value * number).toInt().toString(),
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold

            )

        }
    }
}