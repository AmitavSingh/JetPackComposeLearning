package com.demo.amitav.mycompose.views.timer

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

class Timer {

    @Composable
    fun ShowTimerView() {
        Surface(
            color = Color.Black,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(contentAlignment = Alignment.Center) {
                TimerView(
                    totalTime = 100L * 1000L,
                    circleColor = Color.Green,
                    inactiveColor = Color.DarkGray,
                    activeColor = Color(0xFF37B900) ,
                    modifier = Modifier.size(200.dp)
                )

            }

        }
    }


    @Composable
    fun TimerView(
        totalTime: Long,
        circleColor: Color,
        inactiveColor: Color,
        activeColor: Color,
        initialValue: Float = 1f,
        strokeWidth: Dp = 5.dp,
        modifier: Modifier,
    ) {
        var size by remember {
            mutableStateOf(IntSize.Zero)
        }

        var value by remember {
            mutableStateOf(initialValue)
        }

        var isTimerRunning by remember {
            mutableStateOf(false)
        }

        var currentTime by remember {
            mutableStateOf(totalTime)
        }

        Box(contentAlignment = Alignment.Center,
            modifier = modifier.onSizeChanged {
                size = it
            }) {
            Canvas(modifier = modifier) {
                drawArc(
                    color = inactiveColor,
                    startAngle = -215f,
                    sweepAngle = 250f,
                    useCenter = false,
                    size = Size(size.width.toFloat(), size.height.toFloat()),
                    style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
                )
            }
            Canvas(modifier = modifier) {
                drawArc(
                    color = activeColor,
                    startAngle = -215f,
                    sweepAngle = 250f * value,
                    useCenter = false,
                    size = Size(size.width.toFloat(), size.height.toFloat()),
                    style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
                )

                var center = Offset(size.width / 2f, size.height / 2f)
                val beta = (250f * value + 145f) * (PI / 180f).toFloat()
                var radius = size.width / 2f
                val a = cos(beta) * radius
                val b = sin(beta) * radius

                drawPoints(
                    listOf(Offset(x = center.x + a, y = center.y + b)),
                    pointMode = PointMode.Points,
                    color = circleColor,
                    strokeWidth = (strokeWidth * 3f).toPx(),
                    cap = StrokeCap.Round
                )
            }

            Text(
                text = (currentTime / 1000L).toString(),
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Button(
                onClick = {
                          if (currentTime < 0L){
                              currentTime = totalTime
                              isTimerRunning = true
                          }else{
                              isTimerRunning = !isTimerRunning
                          }
                }, modifier = Modifier
                    .align(Alignment.BottomCenter),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (!isTimerRunning || currentTime <= 0L) {
                        Color.Green
                    } else Color.Red
                )
            ) {
                Text(
                    text = if (isTimerRunning && currentTime > 0L) "STOP"
                    else if (!isTimerRunning && currentTime > 0L) "START"
                    else "Restart"
                )
            }

        }

        LaunchedEffect(key1 = isTimerRunning, key2 = currentTime ){
            if(currentTime >0 && isTimerRunning){
                delay(100L)
                currentTime -= 100L
                value = currentTime / totalTime.toFloat()
            }

        }

    }
}