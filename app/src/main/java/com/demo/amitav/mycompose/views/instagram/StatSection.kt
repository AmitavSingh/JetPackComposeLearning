package com.demo.amitav.mycompose.views.instagram

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class StatSection {

    @Composable
    fun StatSectionView(
        modifier: Modifier = Modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier
        ) {

            ProfileStat(numberText = "601", subTitleText = "Post")
            ProfileStat(numberText = "100K", subTitleText = "Followers")
            ProfileStat(numberText = "132", subTitleText = "Following")
        }
    }


    @Composable
    fun ProfileStat(
        numberText: String,
        subTitleText: String,
        modifier: Modifier = Modifier
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Text(
                text = numberText,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = subTitleText)
        }
    }
}