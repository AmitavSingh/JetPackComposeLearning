package com.demo.amitav.mycompose.views.meditationui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.amitav.mycompose.R
import com.demo.amitav.mycompose.models.BottomMenuContent
import com.demo.amitav.mycompose.models.Features
import com.demo.amitav.mycompose.theme.*

class MeditationUI {

    @Composable
    fun GetMeditationUI() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DeepBlue)
        ) {
            Column {
                GreetingUI()
                ChipSection(items = listOf("Stress", "Body", "Relax", "Its Amitav Here"))
                Event()
                GridView(
                    list = listOf(
                        Features(
                            title = "Sleep meditation",
                            R.drawable.ic_headphone,
                            BlueViolet1,
                            BlueViolet2,
                            BlueViolet3
                        ),
                        Features(
                            title = "Tips for sleeping",
                            R.drawable.ic_videocam,
                            LightGreen1,
                            LightGreen2,
                            LightGreen3
                        ),
                        Features(
                            title = "Night island",
                            R.drawable.ic_headphone,
                            OrangeYellow1,
                            OrangeYellow2,
                            OrangeYellow3
                        ),
                        Features(
                            title = "Calming sounds",
                            R.drawable.ic_headphone,
                            Beige1,
                            Beige2,
                            Beige3
                        )
                    )
                )
            }
            BottomMenu(
                bottomItemList = listOf(
                    BottomMenuContent("Home", R.drawable.ic_home),
                    BottomMenuContent("Meditate", R.drawable.ic_bubble),
                    BottomMenuContent("Sleep", R.drawable.ic_moon),
                    BottomMenuContent("Music", R.drawable.ic_music),
                    BottomMenuContent("Profile", R.drawable.ic_profile),
                ), modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }

    @Composable
    fun GreetingUI(
        name: String = "Amitav Singh"
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = "Hello $name",
                    style = MaterialTheme.typography.h2
                )
                Text(
                    text = "We wish you a good day!",
                    style = MaterialTheme.typography.body1
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }

    @Composable
    fun ChipSection(
        items: List<String>
    ) {
        var selectedIndex by remember {
            mutableStateOf(0)
        }
        LazyRow {
            items(items.size) {
                Box(modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
                    .clickable {
                        selectedIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp),
                    contentAlignment = Alignment.Center) {
                    Text(text = items[it], color = TextWhite)
                }
            }
        }
    }

    @Composable
    fun Event() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(15.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(LightRed)
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = "Daily Thought",
                    style = MaterialTheme.typography.h2
                )
                Text(
                    text = "Meditate Daily",
                    style = MaterialTheme.typography.body1,
                    color = TextWhite
                )
            }
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(ButtonBlue)
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play), contentDescription = "Play",
                    modifier = Modifier.size(16.dp),
                    tint = Color.White
                )
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun GridView(
        list: List<Features>
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Features",
                modifier = Modifier.padding(15.dp),
                style = Typography.h1
            )
            LazyVerticalGrid(
                cells = GridCells.Fixed(count = 2),
                contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
                modifier = Modifier.fillMaxHeight()
            ) {
                items(list.size) {
                    featureGridItem(feature = list[it])
                }
            }
        }
    }

    @Composable
    fun featureGridItem(feature: Features) {
        BoxWithConstraints(
            modifier = Modifier
                .padding(7.5.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp))
                .background(color = feature.darkColor)
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = Typography.h2,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )

            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                modifier = Modifier.align(Alignment.BottomStart)
            )

            Text(
                text = "Start",
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
                    .align(Alignment.BottomEnd),
                color = TextWhite,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )

        }
    }

    @Composable
    fun BottomMenu(
        bottomItemList: List<BottomMenuContent>,
        selectedItemIndex: Int = 0,
        modifier: Modifier
    ) {

        var selectedItemIndex by remember {
            mutableStateOf(selectedItemIndex)
        }

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .background(color = DeepBlue)
                .padding(15.dp),

            ) {
            bottomItemList.forEachIndexed { index, item ->
                BottomMenuItem(item = item, isSelected = index == selectedItemIndex) {
                    selectedItemIndex = index
                }
            }
        }


    }

    @Composable
    fun BottomMenuItem(
        item: BottomMenuContent,
        isSelected: Boolean,
        activeHighlightColor: Color = ButtonBlue,
        activeTextColor: Color = Color.White,
        inactiveTextColor: Color = AquaBlue,
        onItemClick: () -> Unit
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.clickable {
                onItemClick()
            }
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = if (isSelected) activeHighlightColor else Color.Transparent)
                    .padding(10.dp)
            ) {
                Icon(
                    painter = painterResource(id = item.iconId),
                    contentDescription = item.title,
                    tint = if (isSelected) activeTextColor else inactiveTextColor,
                    modifier = Modifier.size(20.dp)
                )
            }
            Text(
                text = item.title,
                color = if (isSelected) activeTextColor else inactiveTextColor
            )
        }

    }
}