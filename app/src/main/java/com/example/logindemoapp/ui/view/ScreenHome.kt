package com.example.logindemoapp.ui.view

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.logindemoapp.ui.theme.LoginDemoAppTheme
import com.example.logindemoapp.ui.view.navview.BottomNavItems
import com.example.logindemoapp.ui.view.navview.ScreenNavActivitiesView
import com.example.logindemoapp.ui.view.navview.ScreenNavGroupsView
import com.example.logindemoapp.ui.view.navview.ScreenNavHomeView
import com.example.logindemoapp.ui.view.navview.ScreenNavResourcesView
import com.example.logindemoapp.ui.view.navview.ScreenNavSkillView
import com.example.logindemoapp.ui.view.navview.getNavItems


@Composable
fun ScreenHomeView(
    logOutAction: () -> Unit
) {
    val navitems = getNavItems()
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController, navitems)
        },
        topBar = {TopApplicationBar(logOutAction = logOutAction)}
    ) { innerPadding ->
        NavHost(
            navController = navController, startDestination = "home_screen"
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopApplicationBar(
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
fun BottomNavigationBar(
    navController: NavHostController,
    navitems: List<BottomNavItems>) {
    BottomNavigation(
        modifier = Modifier.navigationBarsPadding()
    ) {
        navitems.forEachIndexed { index, item ->
            BottomNavigationItem(
                selected = navController.currentBackStackEntryAsState().value?.destination?.route == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // To avoid stack build-up
                        // Pop up to the start destination of the graph to avoid building up the back stack
                        popUpTo = navController.graph.startDestinationId
                        launchSingleTop = true
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