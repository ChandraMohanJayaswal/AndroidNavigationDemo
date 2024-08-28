package com.example.logindemoapp.ui.view

import androidx.compose.foundation.layout.navigationBarsPadding

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.logindemoapp.ui.theme.LoginDemoAppTheme
import com.example.logindemoapp.ui.view.navview.NavCoordinator


@Composable
fun ScreenHomeView(
    logOutAction: () -> Unit
) {
    val navController = rememberNavController()
    val coordinator: NavCoordinator = remember { NavCoordinator(navController) }

    Scaffold(
        bottomBar = {
            BottomBar(navController,coordinator)
        },
        topBar = {
            TopBar(logOutAction = logOutAction)
        }
    ) { innerPadding ->
        coordinator.NavigationHost(innerPadding = innerPadding, startDestination = "home_screen")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    logOutAction : (()->Unit)) {
        TopAppBar(
            title = {
                Text("My App Bar")
            },
            actions = {
                // Button in the TopAppBar
                Button(onClick = { logOutAction()
                }) {
                    androidx.compose.material.Text(text = "LogOut")
                }
            }
        )
}

@Composable
fun BottomBar(
    navController: NavController,
    coordinator: NavCoordinator) {
    NavigationBar(
        modifier = Modifier.navigationBarsPadding()
    ) {
        coordinator.getNavItems().forEachIndexed { index, item ->
            val isSelected = navController.currentBackStackEntryAsState().value?.destination?.route == item.route
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (!isSelected) {
                        coordinator.nagivateTo(item.route)
                    }
                },
                icon = {
                    Icon(item.icon, contentDescription = item.label)
                },
                label = { Text(item.label) }
            )
        }
    }

}
@Preview(showBackground = true)
@Composable
fun ScreenHomeViewPreview(){
    LoginDemoAppTheme {
        ScreenHomeView(logOutAction = {})
    }
}