package com.demo.amitav.mycompose.views.instagram

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.demo.amitav.mycompose.R
import com.demo.amitav.mycompose.views.instagram.models.ModelTabItems

class TabView {

    @Composable
    fun SetupTabView(
        modifier: Modifier = Modifier
    ) {
        var selectedTabIndex by remember {
            mutableStateOf(0)
        }
        ShowTabView(
            tabitems = listOf(
                ModelTabItems(
                    image = painterResource(id = R.drawable.ic_grid),
                    text = "Posts"
                ),
                ModelTabItems(
                    image = painterResource(id = R.drawable.ic_reels),
                    text = "Reels"
                ),
                ModelTabItems(
                    image = painterResource(id = R.drawable.ic_igtv),
                    text = "IGTV"
                ),
                ModelTabItems(
                    image = painterResource(id = R.drawable.profile),
                    text = "Profile"
                ),
            ), onTabSelected = {
                selectedTabIndex = it
            }
        )

        when (selectedTabIndex) {
            0 -> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.kmm),
                    painterResource(id = R.drawable.intermediate_dev),
                    painterResource(id = R.drawable.master_logical_thinking),
                    painterResource(id = R.drawable.bad_habits),
                    painterResource(id = R.drawable.multiple_languages),
                    painterResource(id = R.drawable.learn_coding_fast),
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

    @Composable
    fun ShowTabView(
        modifier: Modifier = Modifier,
        tabitems: List<ModelTabItems>,
        onTabSelected: (selectedIndex: Int) -> Unit
    ) {
        var selectedIndex by remember {
            mutableStateOf(0)
        }
        val inactiveColor = Color(0xFF777777)

        TabRow(
            selectedTabIndex = selectedIndex,
            backgroundColor = Color.Transparent,
            contentColor = Color.Black,
            modifier = modifier
        ) {
            tabitems.forEachIndexed { index, item ->
                Tab(
                    selected = selectedIndex == index,
                    unselectedContentColor = inactiveColor,
                    selectedContentColor = Color.Black,
                    onClick = {
                        selectedIndex = index
                        onTabSelected(index)
                    })
                {
                    Icon(
                        painter = item.image,
                        contentDescription = item.text,
                        tint = if (selectedIndex == index) Color.Black else inactiveColor,
                        modifier = Modifier
                            .padding(10.dp)
                            .size(20.dp)
                    )

                }
            }

        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun PostSection(
        posts: List<Painter>,
        modifier: Modifier = Modifier
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(count = 3),
            modifier = modifier.scale(1.01f)
        ) {
            items(posts.count()) {
                Image(
                    painter = posts[it],
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .border(width = 1.dp, color = Color.White)

                )

            }
        }

    }
}