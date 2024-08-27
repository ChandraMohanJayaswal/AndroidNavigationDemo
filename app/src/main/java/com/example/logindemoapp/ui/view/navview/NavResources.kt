package com.example.logindemoapp.ui.view.navview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.logindemoapp.ui.theme.LoginDemoAppTheme

@Composable
fun ScreenNavResourcesView(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = "Hey This is Resources")
    }

}
@Preview(showBackground = true)
@Composable
fun ScreenNavResourcesViewPreview(){
    LoginDemoAppTheme {
        ScreenNavResourcesView()
    }
}