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
import com.example.logindemoapp.ui.view.AuthScreen.ScreenForgotPassView
import com.example.logindemoapp.ui.view.AuthScreen.ScreenLoginView
import com.example.logindemoapp.ui.view.AuthScreen.ScreenRegisterView
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
        startDestination: String,
        loginBtnAction : (()->Unit),
        coordinator : NavCoordinator
        ) {

        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            composable(route = "home_screen") {
                ScreenNavHomeView()
            }
            composable(route = "activity_screen") {
                ScreenNavActivitiesView()
            }
            composable(route = "skill_screen") {
                ScreenNavSkillView()
            }
            composable(route = "group_screen") {
                ScreenNavGroupsView()
            }
            composable(route = "resources_screen") {
                ScreenNavResourcesView()
            }
            composable(route = "log_screen") {
                ScreenLoginView(loginBtnAction,coordinator)
            }
            composable(route = "register_screen") {
                ScreenRegisterView(coordinator)
            }
            composable(route = "forgot_screen") {
                ScreenForgotPassView(coordinator)
            }
        }
    }

    fun getNavItems(): List<BottomNavItems> {
        return listOf(
            BottomNavItems(NavItems.HOME.label, Icons.Filled.Home, NavItems.HOME.route),
            BottomNavItems(NavItems.ACTIVITY.label, Icons.Filled.AddCircle,NavItems.ACTIVITY.route ),
            BottomNavItems(NavItems.SKILL.label, Icons.Filled.AccountCircle, NavItems.SKILL.route),
            BottomNavItems(NavItems.GROUP.label, Icons.Filled.CheckCircle, NavItems.GROUP.route),
            BottomNavItems(NavItems.RESOURCE.label, Icons.Filled.Info, NavItems.RESOURCE.route)
        )
    }
}

data class BottomNavItems(
    val label: String,
    val icon: ImageVector,
    val route: String
)
enum class NavItems(
    val label : String,
    val route : String
){
    HOME("Home","home_screen"),
    ACTIVITY("Activities","activity_screen"),
    SKILL("Skill","skill_screen"),
    GROUP("Groups","group_screen"),
    RESOURCE("Resources","resources_screen")
}