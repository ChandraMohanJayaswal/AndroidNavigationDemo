package com.example.logindemoapp.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.logindemoapp.R
import com.example.logindemoapp.ui.theme.LoginDemoAppTheme

@Composable
fun ScreenHomeView(
    logOutAction: () -> Unit
){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        BottomNavigationSample(logOutAction =logOutAction )

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationSample(
    logOutAction : (()->Unit)
){
    val context = LocalContext.current
    var seletedItem by remember { mutableStateOf(0)}
    val items = listOf(
        context.getString(R.string.item1),
        context.getString(R.string.item2),
        context.getString(R.string.item3)
    )

    Scaffold (
        bottomBar = {
            BottomNavigation (modifier = Modifier.navigationBarsPadding()){
                items.forEachIndexed{index,item ->
                    BottomNavigationItem(
                        selected =seletedItem==index ,
                        onClick = {seletedItem = index },
                        icon = {
                            Icon(Icons.Filled.Favorite, contentDescription ="fav" )
                        },
                        label = { Text(text = "$item")})
                }
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text("My App Bar")
                },
                actions = {
                    // Button in the TopAppBar
                 Button(onClick = {
                     logOutAction()
                 }) {
                     androidx.compose.material.Text(text = "LogOut")
                 }
                }
            )
        }
    ){ innerPadding ->
        // Your screen content goes here, with the padding applied
    }
}
@Preview(showBackground = true)
@Composable
fun ScreenHomeViewPreview(){
    LoginDemoAppTheme {
        ScreenHomeView(logOutAction = {})
    }
}