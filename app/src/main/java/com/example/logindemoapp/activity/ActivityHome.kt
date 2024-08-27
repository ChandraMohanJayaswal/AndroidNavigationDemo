package com.example.logindemoapp.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import com.example.logindemoapp.ui.theme.LoginDemoAppTheme
import com.example.logindemoapp.ui.view.ScreenHomeView

class ActivityHome : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginDemoAppTheme {
                ScreenHomeView(logOutAction = {
                    logOutButtonCliked()
                })
            }
        }
    }

    private fun logOutButtonCliked() {
        finish()
    }
}