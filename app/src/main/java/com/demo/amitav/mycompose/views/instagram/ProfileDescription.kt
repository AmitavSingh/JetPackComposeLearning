package com.demo.amitav.mycompose.views.instagram

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ProfileDescription {

    @Composable
    fun ProfileDescriptionView(
        name: String,
        description: String,
        url: String,
        followedBy: List<String>,
        otherCount: Int
    ) {
        val letterSpacing = 0.5.sp
        val lineHeight = 20.sp
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
            Text(
                text = description,
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
            Text(
                text = url,
                color = Color(0xFF3D3D91),
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
            Text(
                text = buildAnnotatedString {
                    val boldstyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldstyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldstyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )

        }
    }
}