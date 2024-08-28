package com.example.logindemoapp.coordinator

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.logindemoapp.ui.view.navview.ScreenNavActivitiesView
import com.example.logindemoapp.ui.view.navview.ScreenNavGroupsView
import com.example.logindemoapp.ui.view.navview.ScreenNavHomeView
import com.example.logindemoapp.ui.view.navview.ScreenNavResourcesView
import com.example.logindemoapp.ui.view.navview.ScreenNavSkillView

interface NavCoordinatorInterface {
    fun nagivateTo(route: String)
}

class NavCoordinator(
    val navController: NavHostController
) : NavCoordinatorInterface {

    override fun nagivateTo(route: String) {
        navController.navigate(route) {
            // To avoid stack build-up
            popUpTo(navController.graph.startDestinationId) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    @Composable
    fun NavigationHost(
        innerPadding: PaddingValues,
        startDestination: String
        ) {

        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            composable(route = "home_screen") {
                ScreenNavHomeView(innerPadding)
            }
            composable(route = "activity_screen") {
                ScreenNavActivitiesView(innerPadding)
            }
            composable(route = "skill_screen") {
                ScreenNavSkillView(innerPadding)
            }
            composable(route = "group_screen") {
                ScreenNavGroupsView(innerPadding)
            }
            composable(route = "resources_screen") {
                ScreenNavResourcesView(innerPadding)
            }
        }
    }

    fun getNavItems(): List<BottomNavItems> {
        return listOf(
            BottomNavItems(NavItems.HOME.title, NavItems.HOME.icon, NavItems.HOME.route),
            BottomNavItems(NavItems.ACTIVITY.title, NavItems.ACTIVITY.icon,NavItems.ACTIVITY.route ),
            BottomNavItems(NavItems.SKILL.title, NavItems.SKILL.icon, NavItems.SKILL.route),
            BottomNavItems(NavItems.GROUP.title, NavItems.GROUP.icon, NavItems.GROUP.route),
            BottomNavItems(NavItems.RESOURCE.title, NavItems.RESOURCE.icon, NavItems.RESOURCE.route)
        )
    }
}

data class BottomNavItems(
    val label: String,
    val icon: ImageVector,
    val route: String
)

enum class NavItems(
    val title : String,
    val route : String,
    val icon: ImageVector
){
    HOME("Home","home_screen", icon = Icons.Filled.Home),
    ACTIVITY("Activities","activity_screen", icon = Icons.Filled.AddCircle),
    SKILL("Skill","skill_screen", icon = Icons.Filled.AccountCircle),
    GROUP("Groups","group_screen", icon = Icons.Filled.CheckCircle),
    RESOURCE("Resources","resources_screen", icon = Icons.Filled.Info)
}