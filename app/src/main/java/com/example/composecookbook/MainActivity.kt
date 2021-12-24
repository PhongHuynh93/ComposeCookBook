package com.example.composecookbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecookbook.ui.theme.ComposeCookBookTheme
import com.example.composecookbook.ui.view.home.BottomNavType
import com.example.composecookbook.ui.view.home.HomeScreenContent
import com.example.composecookbook.ui.view.widget.BottomNavigationContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCookBookTheme {
                MainAppContent()
            }
        }
    }
}

@Composable
fun MainAppContent() {
    Column {
        val homeScreenState = rememberSaveable { mutableStateOf(BottomNavType.HOME) }
        HomeScreenContent(
            homeScreen = homeScreenState.value,
            modifier = Modifier.weight(1f)
        )
        BottomNavigationContent(
            homeScreenState = homeScreenState
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCookBookTheme {
        MainAppContent()
    }
}