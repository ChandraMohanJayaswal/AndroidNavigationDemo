package com.example.logindemoapp.ui.view.navview
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

interface NavCoordinatorInterface{
   fun nagivateTo(route : String)
}


class NavCoordinator(
    val navController: NavHostController
)  : NavCoordinatorInterface {

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
        }
    }


    fun getNavItems() : List<BottomNavItems>{
        return listOf(
            BottomNavItems("Home", Icons.Filled.Home,"home_screen"),
            BottomNavItems("Activities", Icons.Filled.AddCircle,"activity_screen"),
            BottomNavItems("Skill", Icons.Filled.AccountCircle,"skill_screen"),
            BottomNavItems("Groups", Icons.Filled.CheckCircle,"group_screen"),
            BottomNavItems("Resources", Icons.Filled.Info,"resources_screen")
        )
    }

}


data class BottomNavItems (
    val label : String,
    val icon : ImageVector,
    val route : String
)