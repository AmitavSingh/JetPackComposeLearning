package com.demo.amitav.mycompose.views.splashscreenwithnavigation


import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.demo.amitav.mycompose.R
import kotlinx.coroutines.delay

class SplashNavigation {

    @Composable
    fun SplashNavigationView() {
        Navigation()
    }


    @Composable
    fun Navigation() {
        var navController = rememberNavController()
        NavHost(navController = navController, startDestination = "splsh_screen") {
            composable("splsh_screen") {
                SplashScreen(navController = navController)
            }

            composable("home_screen") {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {

                    Text(text = "Welcome to home screen")
                }
            }
        }
    }

    @Composable
    fun SplashScreen(navController: NavController) {
        val scale = remember {
            Animatable(0f)
        }
        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 2f,
                animationSpec = tween(
                    durationMillis = 500,
                    easing = {
                        OvershootInterpolator(2f).getInterpolation(it)
                    }
                )

            )
            delay(3000L)
            navController.navigate("home_screen")
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(id = R.drawable.amitav),
                contentDescription = "Null",
                modifier = Modifier.scale(scale.value)
            )
        }
    }
}