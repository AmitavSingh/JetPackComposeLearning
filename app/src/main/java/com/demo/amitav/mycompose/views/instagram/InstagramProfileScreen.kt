package com.demo.amitav.mycompose.views.instagram

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.amitav.mycompose.R
import com.demo.amitav.mycompose.views.instagram.models.ModelHighlight

class InstagramProfileScreen {

    @Composable
    fun GetInstagramView() {
        Surface(
            color = Color.White,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.height(10.dp))
                GetTopBarView(profilename = "AmitavSingh", modifier = Modifier.padding(10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                ProfileSection()
                Spacer(modifier = Modifier.height(25.dp))
                ActionButton().ActionButtonView(modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(25.dp))
                HighlightSection().HighlightSectionView(
                    highlights = listOf(
                        ModelHighlight(
                            image = painterResource(id = R.drawable.youtube),
                            subTitle = "YouTube"
                        ),
                        ModelHighlight(
                            image = painterResource(id = R.drawable.qa),
                            subTitle = "Q&A"
                        ),
                        ModelHighlight(
                            image = painterResource(id = R.drawable.discord),
                            subTitle = "Discord"
                        ),
                        ModelHighlight(
                            image = painterResource(id = R.drawable.telegram),
                            subTitle = "Telegram"
                        )
                    ), modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                TabView().SetupTabView()

            }

        }

    }


    @Composable
    fun GetTopBarView(
        modifier: Modifier = Modifier,
        profilename: String
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back Icon",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = profilename,
                color = Color.Black,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_bell),
                contentDescription = "Notification",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_dotmenu),
                contentDescription = "Menu",
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )
        }
    }

    @Composable
    fun ProfileSection(
        modifier: Modifier = Modifier
    ) {
        Column(modifier = modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                RoundImage().RoundImageView(
                    image = painterResource(id = R.drawable.amitav),
                    modifier = Modifier
                        .size(100.dp)
                        .weight(3f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                StatSection().StatSectionView(modifier = Modifier.weight(7f))
            }
            Spacer(modifier = Modifier.height(10.dp))
            ProfileDescription().ProfileDescriptionView(
                name = "Mobile Developer",
                description = "6 years of coding experience\n" +
                        "Want me to make your app? Send me an email!\n" +
                        "Subscribe to my YouTube channel!",
                url = "https://www.google.com",
                followedBy = listOf("codinginflow", "sachin"),
                otherCount = 5
            )
        }

    }

}

