package com.demo.amitav.mycompose.views.uiComponents

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.demo.amitav.mycompose.MyApplication

class RowAndColumns {

    @Composable
    fun RowView(){
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Amitav", modifier = Modifier.clickable {
                Toast.makeText( MyApplication.applicationContext(), "Hello", Toast.LENGTH_SHORT).show()
            })
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Singh")
        }
    }
}