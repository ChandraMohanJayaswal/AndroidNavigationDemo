package com.example.logindemoapp.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.PaddingValues
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.logindemoapp.R
import com.example.logindemoapp.ui.theme.LoginDemoAppTheme
import com.example.logindemoapp.ui.view.ScreenForgetPasswordView

class ActivityForgetPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginDemoAppTheme {
                ScreenForgetPasswordView(
                    innerPadding = PaddingValues(),
                    backButtonAction = { finish() }
                )
            }
        }
    }
}