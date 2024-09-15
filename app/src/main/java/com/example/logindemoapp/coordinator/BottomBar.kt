package com.example.logindemoapp.coordinator

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(
    coordinator: NavCoordinator
) {
    NavigationBar(
        modifier = Modifier.navigationBarsPadding()
    ) {
        coordinator.getNavItems().forEachIndexed { index, item ->
            val isSelected = coordinator.navHostController.currentBackStackEntryAsState().value?.destination?.route == item.route
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (!isSelected) {
                        coordinator.nagivateTo(item.route)
                    }
                },
                icon = {
                    Icon(item.icon, contentDescription = item.title)
                },
                label = { Text(item.title) }
            )
        }
    }

}