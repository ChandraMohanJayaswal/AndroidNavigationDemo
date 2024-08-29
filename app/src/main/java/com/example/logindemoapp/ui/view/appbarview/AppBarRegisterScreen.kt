package com.example.logindemoapp.ui.view.appbarview

import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.logindemoapp.coordinator.NavCoordinator
import com.example.logindemoapp.ui.theme.LoginDemoAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarRegisterScreenView(coordinator: NavCoordinator) {
    TopAppBar(
        title = {
            Text("Register", modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
        },
        navigationIcon = {
            // Button in the TopAppBar
           Icon(Icons.Filled.ArrowBack, contentDescription = "",
               modifier = Modifier.clickable {
                   coordinator.popBackScreen()
               })
        }
    )
}
@Preview(showBackground = true)
@Composable
fun AppBarRegisterScreenPreview(){
    LoginDemoAppTheme {
        AppBarRegisterScreenView(coordinator =
        NavCoordinator(navController = rememberNavController(), LocalContext.current))
    }
}