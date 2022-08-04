package com.demo.amitav.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.demo.amitav.mycompose.views.bottomnavigationwithbadges.BottomNavigationView
import com.demo.amitav.mycompose.views.bottomsheet.BottomSheet
import com.demo.amitav.mycompose.views.multiselectlazycolumn.MultiSelectColumn
import com.demo.amitav.mycompose.views.permissionhandling.PermissionsHandling

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

//            RowAndColumns().RowView()

//            Card().ImageCard()

//            ColorBox().ColorBox()

//            InputTextAndButton().InputViewAndButton()

//            List().List()

//            ConstraintLayout().ConstraintView()

//            EffectHandler().LaunchedScopeEffect()

//            CircularProgressBar().CircularProgress()

//            CustomTheme {
//                MeditationUI().GetMeditationUI()
//            }

//            Timer().ShowTimerView()

//            InstagramProfileScreen().GetInstagramView()

//            MainNavigationScreen().NavigationScreen()

//            SplashNavigation().SplashNavigationView()

//            BottomNavigationView().GetView()

//            MultiSelectColumn().GetView()

//            PermissionsHandling().Show()

            BottomSheet().GetView()

        }
    }


}


