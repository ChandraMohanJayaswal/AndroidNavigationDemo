package com.example.logindemoapp.ui.view.AuthScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.logindemoapp.coordinator.NavCoordinator
import com.example.logindemoapp.ui.theme.LoginDemoAppTheme
import com.example.logindemoapp.ui.view.appbarview.AppBarRegisterScreenView

@Composable
fun ScreenRegisterView(
    coordinator: NavCoordinator
) {
    Scaffold(
        topBar = { AppBarRegisterScreenView(coordinator) }
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
            contentAlignment = Alignment.Center){
            Text(text = "Hey This is Register Password")
        }

    }
}
@Preview(showBackground = true)
@Composable
fun ScreenRegisterViewPreview(){
    LoginDemoAppTheme {
        ScreenRegisterView(coordinator = NavCoordinator(navController = rememberNavController(),
            LocalContext.current))
    }
}
