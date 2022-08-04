package com.demo.amitav.mycompose.views.uiComponents

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class List {
    
    @SuppressLint("NotConstructor")
    @Composable
    fun List(){
        
        LazyColumn{
            itemsIndexed(items = listOf("Hi", "This", "Is", "Amitav"), itemContent = {
                index, item ->
                Text(text = "$item + $index", modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

            })
        }
       
    }


}