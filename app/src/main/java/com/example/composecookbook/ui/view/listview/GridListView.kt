package com.example.composecookbook.ui.view.listview

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecookbook.data.DemoDataProvider
import com.example.composecookbook.ui.theme.ComposeCookBookTheme
import com.example.composecookbook.ui.view.widget.VerticalGrid

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridListView() {
    val list = remember { DemoDataProvider.itemList.take(4) }
    val profiles = remember { DemoDataProvider.tweetList }

    //TODO: NO IN-BUILT GRID VIEW NOT AVAILABLE YET USING ROWS FOR NOW
    // GRIDS are not lazy driven yet so let's wait for Lazy Layout to make grids
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        VerticalGrid(columns = 2,
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp),
            content = {
                list.forEach {
                    HorizontalItem(
                        item = it,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
            })
        VerticalGrid(columns = 4,
            modifier = Modifier.padding(vertical = 16.dp),
            content = {
                profiles.forEach {
                    StoryItem(
                        item = it, isMe = it.id == 1,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
            })
    }
}

@Preview(heightDp = 600)
@Composable
fun GridListPreview() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            GridListView()
        }
    }
}
