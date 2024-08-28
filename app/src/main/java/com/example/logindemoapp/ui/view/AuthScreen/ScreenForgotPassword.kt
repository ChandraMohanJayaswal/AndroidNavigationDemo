package com.example.logindemoapp.ui.view.AuthScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.logindemoapp.coordinator.NavCoordinator
import com.example.logindemoapp.ui.view.appbarview.AppBarForgotPassScreenView
import com.example.logindemoapp.ui.view.appbarview.AppBarRegisterScreenView

@Composable
fun ScreenForgotPassView(coordinator: NavCoordinator) {
    Scaffold(
        topBar = { AppBarForgotPassScreenView(coordinator) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Hey This is Forget Password")
        }

    }
}