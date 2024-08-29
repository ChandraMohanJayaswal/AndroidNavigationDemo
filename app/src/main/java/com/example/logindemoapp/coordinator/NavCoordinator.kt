package com.example.logindemoapp.coordinator

import android.content.Context
import android.content.Intent
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
    fun moveToHomeActivity(activityClass: Class<*>)
    fun moveToLogActivity(activityClass: Class<*>)
}

class NavCoordinator(
    val navController: NavHostController,
    private val context : Context
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

    override fun moveToHomeActivity(activityClass: Class<*>) {
        val intent = Intent(context, activityClass)
        // Check if the activity is already in the stack
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(intent)
    }

    override fun moveToLogActivity(activityClass: Class<*>) {
        val intent = Intent(context, activityClass)
        // Check if the activity is already in the stack
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(intent)
    }


    @Composable
    fun NavigationHost(
        innerPadding: PaddingValues,
        startDestination: String,
        coordinator : NavCoordinator
        ) {

        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            composable(route = NavItems.HOME.route) {
                ScreenNavHomeView(innerPadding)
            }
            composable(route = NavItems.ACTIVITY.route) {
                ScreenNavActivitiesView(innerPadding)
            }
            composable(route = NavItems.SKILL.route) {
                ScreenNavSkillView(innerPadding)
            }
            composable(route = NavItems.GROUP.route) {
                ScreenNavGroupsView(innerPadding)
            }
            composable(route = NavItems.RESOURCE.route) {
                ScreenNavResourcesView(innerPadding)
            }
            composable(route = NavItems.LOG.route) {
                ScreenLoginView(coordinator)
            }
            composable(route = NavItems.REGISTER.route) {
                ScreenRegisterView(coordinator)
            }
            composable(route = NavItems.FORGOT.route) {
                ScreenForgotPassView(coordinator)
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
    RESOURCE("Resources","resources_screen", icon = Icons.Filled.Info),
    LOG("Log","log_screen",icon = Icons.Filled.Info),
    REGISTER("Register","register_screen",icon = Icons.Filled.Info),
    FORGOT("Forget","forgot_screen",icon = Icons.Filled.Info)
}