package com.example.composecookbook.ui.view.widget

import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecookbook.ui.theme.ComposeCookBookTheme
import com.example.composecookbook.ui.view.home.BottomNavType
import com.example.composecookbook.utils.RotateIcon
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons

@Composable
fun BottomNavigationContent(
    homeScreenState: MutableState<BottomNavType>
) {
    var animate by remember { mutableStateOf(false) }
    NavigationBar {
        NavigationBarItem(
            selected = homeScreenState.value == BottomNavType.HOME,
            onClick = {
                homeScreenState.value = BottomNavType.HOME
                animate = false
            },
            icon = {
                FaIcon(
                    faIcon = FaIcons.Home,
                    tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                )
            }
        )
        NavigationBarItem(
            selected = homeScreenState.value == BottomNavType.WIDGETS,
            onClick = {
                homeScreenState.value = BottomNavType.WIDGETS
                animate = false
            },
            icon = {
                FaIcon(
                    faIcon = FaIcons.Tools,
                    tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                )
            }
        )
        NavigationBarItem(
            selected = homeScreenState.value == BottomNavType.ANIMATION,
            onClick = {
                homeScreenState.value = BottomNavType.ANIMATION
                animate = true
            },
            icon = {
                RotateIcon(
                    state = animate,
                    asset = Icons.Default.PlayArrow,
                    angle = 720f,
                    duration = 2000
                )
            }
        )
        NavigationBarItem(
            selected = homeScreenState.value == BottomNavType.DEMOUI,
            onClick = {
                homeScreenState.value = BottomNavType.DEMOUI
                animate = false
            },
            icon = {
                FaIcon(
                    faIcon = FaIcons.LaptopCode,
                    tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                )
            }
        )
        NavigationBarItem(
            selected = homeScreenState.value == BottomNavType.TEMPLATE,
            onClick = {
                homeScreenState.value = BottomNavType.TEMPLATE
                animate = false
            },
            icon = {
                FaIcon(
                    faIcon = FaIcons.LayerGroup,
                    tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                )
            }
        )
    }
}

@Preview(name = "Home")
@Composable
fun BottomNavigationContentPreview() {
    val homeScreenState = rememberSaveable { mutableStateOf(BottomNavType.HOME) }

    ComposeCookBookTheme {
        BottomNavigationContent(homeScreenState)
    }
}
