package com.demo.amitav.mycompose.views.instagram

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.demo.amitav.mycompose.views.instagram.models.ModelHighlight

class HighlightSection {

    @Composable
    fun HighlightSectionView(
        modifier: Modifier = Modifier,
        highlights: List<ModelHighlight>
    ) {
        LazyRow(modifier = modifier) {
            items(highlights.count()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(end = 15.dp)
                ) {
                    RoundImage().RoundImageView(
                        image = highlights[it].image,
                        modifier = Modifier.size(70.dp)
                    )
                    Text(
                        text = highlights[it].subTitle,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}