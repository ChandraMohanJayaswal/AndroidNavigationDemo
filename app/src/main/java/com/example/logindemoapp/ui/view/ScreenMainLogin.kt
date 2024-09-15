package com.example.logindemoapp.ui.view

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.logindemoapp.coordinator.NavCoordinator

@Composable
fun ScreenMainLogin(
    startDestination : String
){
    val context = LocalContext.current
    val navController = rememberNavController()
    val coordinator: NavCoordinator = remember { NavCoordinator(navController,context) }

    Scaffold(
    ) { innerPadding ->
        coordinator.NavigationHost(
            innerPadding = innerPadding,
            startDestination = startDestination,
            coordinator = coordinator)
    }

}