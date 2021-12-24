package com.example.composecookbook.ui.view.home.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecookbook.ui.theme.ComposeCookBookTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(text = "Compose CookBook")
                },
                actions = {

                }
            )
        },
        content = {
            HomeScreenContent()
        }
    )
}

@Composable
fun HomeScreenContent() {

}

@Preview
@Composable
fun HomeScreenPreview() {
    ComposeCookBookTheme {
        HomeScreen()
    }
}
