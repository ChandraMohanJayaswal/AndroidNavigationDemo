package com.example.logindemoapp.ui.view.navview
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

interface NavCoordinatorInterface{
   fun nagivateTo(route : String)
}
class NavCoordinator(
    val navController: NavHostController
)  : NavCoordinatorInterface{

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
}