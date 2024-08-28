package com.example.logindemoapp.ui.view

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.logindemoapp.coordinator.BottomBar
import com.example.logindemoapp.coordinator.NavCoordinator
import com.example.logindemoapp.coordinator.TopBar
import com.example.logindemoapp.ui.theme.LoginDemoAppTheme


@Composable
fun ScreenHomeView(
    startDestination: String,
    logOutAction: () -> Unit
) {
    val navController = rememberNavController()
    val coordinator: NavCoordinator = remember { NavCoordinator(navController) }

    Scaffold(
        bottomBar = { BottomBar(coordinator)},
        topBar = { TopBar(logOutAction = logOutAction) }
    ) { innerPadding ->
        coordinator.NavigationHost(innerPadding = innerPadding, startDestination = startDestination)
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenHomeViewPreview(){
    LoginDemoAppTheme {
        ScreenHomeView(logOutAction = {}, startDestination = "home_screen")
    }
}