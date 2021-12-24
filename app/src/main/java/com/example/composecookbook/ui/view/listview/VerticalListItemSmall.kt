package com.example.composecookbook.ui.view.listview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun VerticalListItemSmall(
    item: Item,
    modifier: Modifier = Modifier
) {
    val isFavorite = remember { mutableStateOf(false) }
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
                .clip(androidx.compose.material.MaterialTheme.shapes.medium)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = item.subtitle,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        IconToggleButton(
            checked = isFavorite.value,
            onCheckedChange = {
                isFavorite.value = it
            }
        ) {
            if (isFavorite.value) {
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

@Preview
@Composable
fun VerticalListItemSmallPreview() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            VerticalListItemSmall(DemoDataProvider.itemList[0])
        }
    }
}
