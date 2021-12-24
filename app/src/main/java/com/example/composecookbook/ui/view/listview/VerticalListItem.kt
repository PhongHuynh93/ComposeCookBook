package com.example.composecookbook.ui.view.listview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
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
                .clip(shape = androidx.compose.material.MaterialTheme.shapes.medium)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = item.title,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = item.subtitle,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = item.source,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Preview
@Composable
fun VerticalListItemPreview() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            VerticalListItem(
                item = DemoDataProvider.itemList[0]
            )
        }
    }
}
