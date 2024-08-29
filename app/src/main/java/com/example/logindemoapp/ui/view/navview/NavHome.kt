package com.example.logindemoapp.ui.view.navview

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anu.todoretrofit.ui.ToDoView
import com.anu.todoretrofit.ui.TodoViewModel
import com.example.logindemoapp.ui.theme.LoginDemoAppTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScreenNavHomeView(innerPadding: PaddingValues){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = "Hey This is Home")
                ToDoView(innerPadding = innerPadding, viewModel = TodoViewModel())
    }

}
@Preview(showBackground = true)
@Composable
fun ScreenNavHomeViewPreview(){
    LoginDemoAppTheme {
        ScreenNavHomeView(innerPadding = PaddingValues())
    }
}