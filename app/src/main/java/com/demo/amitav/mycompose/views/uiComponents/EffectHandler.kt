package com.demo.amitav.mycompose.views.uiComponents

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class EffectHandler {

    @SuppressLint("UnrememberedMutableState")
    @Composable
    fun LaunchedScopeEffect() {

//        LaunchedEffect(key1 = Unit){
//            while (true){
//                delay(1000)
//                timer++
//            }
//        }

//        SideEffect {
//            Thread.sleep(1000)
//            timer++
//        }
//        Thread.sleep(1000)
//        timer++

//        var timerStartStop by remember { mutableStateOf(false) }
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                Button(onClick = {
//                    timerStartStop = !timerStartStop
//                }) {
//                    Text(if (timerStartStop) "Stop" else "Start")
//                }
//            }
//        }
//
//        val context = LocalContext.current
//
//        DisposableEffect(key1 = timerStartStop) {
//            val x = (1..10).random()
//            Toast.makeText(context, "Start $x", LENGTH_SHORT).show()
//
//            onDispose {
//                Toast.makeText(context, "Stop $x", LENGTH_SHORT).show()
//            }
//        }



//        val scope = rememberCoroutineScope()
//        var timer by remember { mutableStateOf(0) }
//        var timerStartStop by remember { mutableStateOf(false) }
//        var job: Job? by remember { mutableStateOf(null) }
//
//        Box(modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center) {
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                Text("Time $timer")
//                Button(onClick = {
//                    timerStartStop = !timerStartStop
//
//                    if (timerStartStop) {
//                        job?.cancel()
//                        job = scope.launch {
//                            while (true) {
//                                delay(1000)
//                                timer++
//                            }
//                        }
//                    } else {
//                        job?.cancel()
//                        timer = 0
//                    }
//
//                }) {
//                    Text(if (timerStartStop) "Stop" else "Start")
//                }
//            }
//        }


       var timer = 1
        val myRememberTimer by rememberUpdatedState(timer)
        Text("Time $myRememberTimer")
        LaunchedEffect(key1 = Unit) {
            delay(1000)
            timer++
            Log.d("Track", "$myRememberTimer")
        }
    }
}