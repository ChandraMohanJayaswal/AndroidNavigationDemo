package com.example.logindemoapp.ui.view.AuthScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.logindemoapp.coordinator.NavCoordinator
import com.example.logindemoapp.ui.theme.LoginDemoAppTheme

@Composable
fun ScreenLoginView(
loginButtonClicked : (()->Unit),
coordinator: NavCoordinator
){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = {  loginButtonClicked() }
        ) {
           Text(text = "Login")
        }
        Button(
            onClick = { coordinator.nagivateTo("register_screen")}
        ) {
            Text(text = "Register")
        }
        Button(
            onClick = { coordinator.nagivateTo("forgot_screen") }
        ) {
            Text(text = "Forget Password")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ScreenLoginViewPreview(){
    LoginDemoAppTheme {
        ScreenLoginView(loginButtonClicked = {}, coordinator =
        NavCoordinator(navController = rememberNavController()))
    }
}