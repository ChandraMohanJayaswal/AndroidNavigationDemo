package com.example.logindemoapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.logindemoapp.ui.theme.LoginDemoAppTheme
import com.example.logindemoapp.ui.view.AuthScreen.ScreenLoginView
import com.example.logindemoapp.ui.view.ScreenMainLogin

class ActivityLogin : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginDemoAppTheme {
               ScreenMainLogin(
                   startDestination = "log_screen"
               )
            }
        }
    }


}