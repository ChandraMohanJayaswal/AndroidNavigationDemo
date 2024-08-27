package com.example.logindemoapp.ui.view.navview

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItems (
    val label : String,
    val icon : ImageVector,
    val route : String
)
fun getNavItems() : List<BottomNavItems>{
    return listOf(
        BottomNavItems("Home", Icons.Filled.Home,"home_screen"),
        BottomNavItems("Activities", Icons.Filled.AddCircle,"activity_screen"),
        BottomNavItems("Skill", Icons.Filled.AccountCircle,"skill_screen"),
        BottomNavItems("Groups", Icons.Filled.CheckCircle,"group_screen"),
        BottomNavItems("Resources", Icons.Filled.Info,"resources_screen")
    )
}