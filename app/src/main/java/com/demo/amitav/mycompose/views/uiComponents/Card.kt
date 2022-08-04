package com.demo.amitav.mycompose.views.uiComponents

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.amitav.mycompose.R

class Card {

    @SuppressLint("ResourceType")
    @Composable
    fun ImageCard(
        modifier: Modifier = Modifier
    ) {
        var painter = painterResource(id = R.drawable.space_image)
        var title = "Astraunaut is in the space"

        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(15.dp)
        ) {
            Card(
                modifier = modifier,
                shape = RoundedCornerShape(15.dp),
                elevation = 5.dp
            ) {
                Box(modifier = Modifier.height(200.dp)) {
                    Image(
                        painter = painter, contentDescription = title,
                        contentScale = ContentScale.Crop
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.verticalGradient(
                                    listOf(Color.Transparent, Color.Black), startY = 300f
                                )
                            )
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
                    }
                }

            }

        }

    }
}