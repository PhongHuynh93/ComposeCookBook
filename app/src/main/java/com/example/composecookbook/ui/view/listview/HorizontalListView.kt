package com.example.composecookbook.ui.view.listview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecookbook.data.DemoDataProvider
import com.example.composecookbook.data.model.Item
import com.example.composecookbook.ui.theme.ComposeCookBookTheme

@Composable
fun HorizontalListView() {
    val list = remember { DemoDataProvider.itemList }
    val profiles = remember { DemoDataProvider.tweetList }

    Column(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(bottom = 24.dp)
    ) {
        Text(
            text = "Good Food",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )
        LazyRow(
            modifier = Modifier.padding(top = 16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = list,
                itemContent = {
                    HorizontalItem(
                        item = it,
                        modifier = Modifier.width(280.dp)
                    )
                }
            )
        }
        ListItemDivider(
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "Stories",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )
        LazyRow(
            modifier = Modifier.padding(top = 16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = profiles,
                itemContent = {
                    StoryItem(it, it.id == 1)
                }
            )
        }
    }
}

@Composable
fun HorizontalItem(item: Item, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
    ) {
        Column {
            Image(
                painter = painterResource(id = item.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(60.dp)
            )
            Column(Modifier.padding(all = 16.dp)) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = item.subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview(name = "Horizontal List")
@Composable
fun HorizontalListPreview() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            HorizontalListView()
        }
    }
}

@Preview(name = "Horizontal List")
@Composable
fun HorizontalItemPreview() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            HorizontalItem(DemoDataProvider.itemList[0])
        }
    }
}
