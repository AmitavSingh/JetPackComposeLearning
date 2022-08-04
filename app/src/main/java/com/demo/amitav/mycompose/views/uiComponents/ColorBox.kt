package com.demo.amitav.mycompose.views.uiComponents

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

class ColorBox {

    @SuppressLint("NotConstructor")
    @Composable
    fun ColorBox(modifier: Modifier = Modifier){

        val color =   remember {
            mutableStateOf(Color.Yellow)
        }
        Box(modifier = modifier.fillMaxSize().background(color.value).clickable {
            color.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )
        })
    }
}