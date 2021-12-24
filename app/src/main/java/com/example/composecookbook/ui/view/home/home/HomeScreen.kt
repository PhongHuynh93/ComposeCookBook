package com.example.composecookbook.ui.view.home.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecookbook.data.DemoDataProvider
import com.example.composecookbook.data.model.HomeScreenItems
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

// TODO: support wider screen
@Composable
fun HomeScreenContent() {
    val list = remember { DemoDataProvider.homeScreenListItems }
    LazyColumn(content = {
        items(
            items = list,
            itemContent = {
                HomeScreenListView(it)
            }
        )
    })
}

@Composable
fun HomeScreenListView(homeScreenItems: HomeScreenItems) {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = homeScreenItems.name,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    ComposeCookBookTheme {
        HomeScreen()
    }
}
