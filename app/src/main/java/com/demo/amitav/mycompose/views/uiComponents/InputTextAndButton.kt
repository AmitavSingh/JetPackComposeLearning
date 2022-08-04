package com.demo.amitav.mycompose.views.uiComponents;

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class InputTextAndButton {

    @Composable
    fun InputViewAndButton() {

        val scaffoldState = rememberScaffoldState()
        var textFieldState by remember {
            mutableStateOf("")
        }
        val scope = rememberCoroutineScope()


        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(value = textFieldState, label = {
                    Text(text = "Enter your name")
                }, onValueChange = {
                    textFieldState = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
                    }
                }) {
                    Text(text = "Greet Me!")
                }
            }

        }
    }
}
