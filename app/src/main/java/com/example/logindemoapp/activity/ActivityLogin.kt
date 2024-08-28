package com.example.logindemoapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues

import com.example.logindemoapp.ui.theme.LoginDemoAppTheme
import com.example.logindemoapp.ui.view.ScreenLoginView

class ActivityLogin : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginDemoAppTheme {
                ScreenLoginView(innerPadding = PaddingValues(),loginButtonAction = {
                    loginButtonClicked()
                })
            }
        }
    }

    private fun loginButtonClicked() {
        val intent = Intent(this,ActivityHome::class.java)
        startActivity(intent)
    }
}