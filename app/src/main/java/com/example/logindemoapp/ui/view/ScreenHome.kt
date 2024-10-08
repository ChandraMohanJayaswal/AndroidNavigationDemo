package com.example.logindemoapp.ui.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.anu.todoretrofit.ui.ToDoView
import com.example.logindemoapp.coordinator.BottomBar
import com.example.logindemoapp.coordinator.NavCoordinator
import com.example.logindemoapp.coordinator.TopBar
import com.example.logindemoapp.ui.theme.LoginDemoAppTheme


@Composable
fun ScreenHomeView(
    innerPadding: PaddingValues,
    startDestination: String
) {
    val context = LocalContext.current
    val navController = rememberNavController()
    val coordinator: NavCoordinator = remember { NavCoordinator(navController,context) }

    Scaffold(
        bottomBar = { BottomBar(coordinator)},
        topBar = { TopBar(coordinator) }
    ) { innerPadding ->
        coordinator.NavigationHost(innerPadding = innerPadding,
            startDestination = startDestination,coordinator)

    }
}

@Preview
@Composable
fun ScreenHomeViewPreview(){
    LoginDemoAppTheme {
        ScreenHomeView(
            innerPadding = PaddingValues(),
            startDestination = "home_screen")
    }
}