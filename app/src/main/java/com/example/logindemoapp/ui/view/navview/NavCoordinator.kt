package com.example.logindemoapp.ui.view.navview
import androidx.navigation.NavHostController

interface NavCoordinatorInterface{
   fun nagivateTo(route : String)
}
class NavCoordinator(
   private val navController: NavHostController
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
}