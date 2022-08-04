package com.demo.amitav.mycompose.views.instagram

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ActionButton {

    @Composable
    fun ActionButtonView(modifier: Modifier = Modifier) {
        val minWidth = 95.dp
        val height = 30.dp
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
        ) {

            ButtonView(
                buttonText = "Following",
                buttonIcon = Icons.Default.KeyboardArrowDown,
                modifier = Modifier
                    .defaultMinSize(minWidth = minWidth)
                    .height(height)
            )

            ButtonView(
                buttonText = "Message",
                modifier = Modifier
                    .defaultMinSize(minWidth = minWidth)
                    .height(height)
            )

            ButtonView(
                buttonText = "Email",
                modifier = Modifier
                    .defaultMinSize(minWidth = minWidth)
                    .height(height)
            )

            ButtonView(
                buttonIcon = Icons.Default.KeyboardArrowDown,
                modifier = Modifier.size(height)
            )
        }
    }

    @Composable
    fun ButtonView(
        modifier: Modifier = Modifier,
        buttonText: String? = null,
        buttonIcon: ImageVector? = null
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(6.dp)
        ) {

            if (buttonText != null) {
                Text(
                    text = buttonText,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
            }
            if (buttonIcon != null) {
                Icon(
                    imageVector = buttonIcon,
                    contentDescription = null,
                    tint = Color.Black
                )
            }

        }

    }
}