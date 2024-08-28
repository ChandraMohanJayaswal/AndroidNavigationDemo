package com.example.logindemoapp.ui.view.navview

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItems(
    val label: String,
    val icon: ImageVector,
    val route: String
)

enum class NavItems(
    val label: String,
    val route : String
){
    HOME("Home","home_screen"),
    ACTIVITY("Activities","activity_screen"),
    SKILL("Skill","skill_screen"),
    GROUP("Groups","group_screen"),
    RESOURCE("Resources","resources_screen")
}

fun getNavItems(): List<BottomNavItems> {
    return listOf(
        BottomNavItems(NavItems.HOME.label, Icons.Filled.Home, NavItems.HOME.route),
        BottomNavItems(NavItems.ACTIVITY.label, Icons.Filled.AddCircle, NavItems.ACTIVITY.route),
        BottomNavItems(NavItems.SKILL.label, Icons.Filled.AccountCircle, NavItems.SKILL.route),
        BottomNavItems(NavItems.GROUP.label, Icons.Filled.CheckCircle, NavItems.GROUP.route),
        BottomNavItems(NavItems.RESOURCE.label, Icons.Filled.Info, NavItems.RESOURCE.route)
    )
}