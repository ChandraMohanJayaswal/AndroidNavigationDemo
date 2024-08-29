package com.example.logindemoapp.ui.view.AuthScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.logindemoapp.activity.ActivityHome
import com.example.logindemoapp.coordinator.NavCoordinator
import com.example.logindemoapp.coordinator.ScreenItems
import com.example.logindemoapp.ui.theme.LoginDemoAppTheme

@Composable
fun ScreenLoginView(coordinator: NavCoordinator){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = {   coordinator.moveToHomeActivity(ActivityHome::class.java) }
        ) {
           Text(text = "Login")
        }
        Button(
            onClick = { coordinator.nagivateTo(ScreenItems.REGISTER.route)}
        ) {
            Text(text = "Register")
        }
        Button(
            onClick = { coordinator.nagivateTo(ScreenItems.FORGOT.route) }
        ) {
            Text(text = "Forget Password")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ScreenLoginViewPreview(){
    LoginDemoAppTheme {
        ScreenLoginView( coordinator =
        NavCoordinator(navController = rememberNavController(), LocalContext.current))
    }
}