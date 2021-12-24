package com.example.composecookbook.ui.view.home

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecookbook.ui.theme.ComposeCookBookTheme
import com.example.composecookbook.ui.view.home.animation.AnimationScreen
import com.example.composecookbook.ui.view.home.demo.DemoScreen
import com.example.composecookbook.ui.view.home.home.HomeScreen
import com.example.composecookbook.ui.view.home.template.TemplateScreen
import com.example.composecookbook.ui.view.home.widget.WidgetScreen
import com.example.composecookbook.ui.view.widget.BottomNavigationContent

@Composable
fun HomeScreenContent(
    homeScreen: BottomNavType,
) {
    Column {
        Crossfade(targetState = homeScreen) { screen ->
            Surface(
                color = MaterialTheme.colorScheme.background
            ) {
                when (screen) {
                    BottomNavType.HOME -> HomeScreen()
                    BottomNavType.WIDGETS -> WidgetScreen()
                    BottomNavType.ANIMATION -> AnimationScreen()
                    BottomNavType.DEMOUI -> DemoScreen()
                    BottomNavType.TEMPLATE -> TemplateScreen()
                }
            }
        }
    }
}

@Preview(name = "Home")
@Composable
fun HomeScreenContentPreview() {
    ComposeCookBookTheme {
        HomeScreenContent(homeScreen = BottomNavType.HOME)
    }
}
