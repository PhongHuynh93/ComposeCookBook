package com.example.composecookbook.ui.view.listview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecookbook.data.DemoDataProvider
import com.example.composecookbook.data.model.Item
import com.example.composecookbook.ui.theme.ComposeCookBookTheme

@Composable
fun VerticalListView() {
    val list = remember { DemoDataProvider.itemList }

    LazyColumn {
        items(
            items = list,
            itemContent = { item ->
                if ((item.id % 3) == 0) {
                    VerticalListItemSmall(item = item)
                } else {
                    VerticalListItem(item = item)
                }
                ListItemDivider()
            }
        )
    }
}


@Composable
fun VerticalListItem(
    item: Item,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = item.imageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(152.dp)
                .fillMaxWidth()
                .clip(shape = MaterialTheme.shapes.medium)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = item.title,
            style = androidx.compose.material3.MaterialTheme.typography.titleLarge
        )
        Text(
            text = item.subtitle,
            style = androidx.compose.material3.MaterialTheme.typography.bodyMedium
        )
        Text(
            text = item.source,
            style = androidx.compose.material3.MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
fun VerticalListItemSmall(
    item: Item,
    modifier: Modifier = Modifier
) {
    var isFavorite by remember { mutableStateOf(false) }
    Row(
        modifier = modifier
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = item.imageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(100.dp)
                .height(80.dp)
                .clip(MaterialTheme.shapes.medium)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        ) {
            Text(
                text = item.title,
                style = androidx.compose.material3.MaterialTheme.typography.titleMedium
            )
            Text(
                text = item.subtitle,
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium
            )
        }
        IconToggleButton(
            checked = isFavorite,
            onCheckedChange = {
                isFavorite = it
            }
        ) {
            if (isFavorite) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = null
                )
            } else {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview(name = "Vertical list")
@Composable
fun VerticalListPreview() {
    ComposeCookBookTheme {
        ListViewContent("Vertical") {}
    }
}

@Preview(name = "Large vertical item")
@Composable
fun VerticalListItemPreview() {
    ComposeCookBookTheme {
        Surface(
            color = androidx.compose.material3.MaterialTheme.colorScheme.background
        ) {
            VerticalListItem(
                item = DemoDataProvider.itemList[0]
            )
        }
    }
}

@Preview(name = "Small vertical item")
@Composable
fun VerticalListItemSmallPreview() {
    ComposeCookBookTheme {
        Surface(
            color = androidx.compose.material3.MaterialTheme.colorScheme.background
        ) {
            VerticalListItemSmall(DemoDataProvider.itemList[0])
        }
    }
}
