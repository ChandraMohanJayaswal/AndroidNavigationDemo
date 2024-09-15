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
    val navHostController: NavHostController,
    private val context : Context
) : NavCoordinatorInterface {

    override fun nagivateTo(route: String) {
        navHostController.navigate(route) {
            // To avoid stack build-up
            popUpTo(navHostController.graph.startDestinationId) {
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
            navController = navHostController,
            startDestination = startDestination
        ) {
            composable(route = ScreenItems.HOME.route) {
                ScreenNavHomeView(innerPadding)
            }
            composable(route = ScreenItems.ACTIVITY.route) {
                ScreenNavActivitiesView(innerPadding)
            }
            composable(route = ScreenItems.SKILL.route) {
                ScreenNavSkillView(innerPadding)
            }
            composable(route = ScreenItems.GROUP.route) {
                ScreenNavGroupsView(innerPadding)
            }
            composable(route = ScreenItems.RESOURCE.route) {
                ScreenNavResourcesView(innerPadding)
            }
            composable(route = ScreenItems.LOGIN.route) {
                ScreenLoginView(coordinator)
            }
            composable(route = ScreenItems.REGISTER.route) {
                ScreenRegisterView(coordinator)
            }
            composable(route = ScreenItems.FORGOT.route) {
                ScreenForgotPassView(coordinator)
            }
        }
    }

    fun getNavItems(): List<BottomNavItem> {
        return listOf(
            BottomNavItem(title = ScreenItems.HOME.title, icon = ScreenItems.HOME.icon, route = ScreenItems.HOME.route),
            BottomNavItem(title = ScreenItems.ACTIVITY.title, icon = ScreenItems.ACTIVITY.icon, route = ScreenItems.ACTIVITY.route ),
            BottomNavItem(title = ScreenItems.SKILL.title, icon = ScreenItems.SKILL.icon, route = ScreenItems.SKILL.route),
            BottomNavItem(title = ScreenItems.GROUP.title, icon = ScreenItems.GROUP.icon, route = ScreenItems.GROUP.route),
            BottomNavItem(title = ScreenItems.RESOURCE.title, icon = ScreenItems.RESOURCE.icon, route = ScreenItems.RESOURCE.route)
        )
    }
}

data class BottomNavItem(
    val title: String,
    val route: String,
    val icon: ImageVector
)

enum class ScreenItems(
    val title : String,
    val route : String,
    val icon: ImageVector
){
    HOME("Home","home_screen", icon = Icons.Filled.Home),
    ACTIVITY("Activities","activity_screen", icon = Icons.Filled.AddCircle),
    SKILL("Skill","skill_screen", icon = Icons.Filled.AccountCircle),
    GROUP("Groups","group_screen", icon = Icons.Filled.CheckCircle),
    RESOURCE("Resources","resources_screen", icon = Icons.Filled.Info),
    LOGIN("Login","login_screen",icon = Icons.Filled.Info),
    REGISTER("Register","register_screen",icon = Icons.Filled.Info),
    FORGOT("Forget","forgot_screen",icon = Icons.Filled.Info)
}