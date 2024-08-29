package com.example.logindemoapp.coordinator

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.example.logindemoapp.activity.ActivityLogin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    coordinator: NavCoordinator) {
    TopAppBar(
        title = {
            Text("My App Bar")
        },
        actions = {
            // Button in the TopAppBar
            Button(onClick = { coordinator.moveToActivity(ActivityLogin::class.java)
            }) {
                androidx.compose.material.Text(text = "LogOut")
            }
        }
    )
}