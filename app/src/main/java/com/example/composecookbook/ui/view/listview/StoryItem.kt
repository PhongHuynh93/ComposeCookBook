package com.example.composecookbook.ui.view.listview

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecookbook.data.DemoDataProvider
import com.example.composecookbook.data.model.Tweet
import com.example.composecookbook.ui.theme.ComposeCookBookTheme
import com.example.composecookbook.ui.theme.instagramGradient

@Composable
fun StoryItem(item: Tweet, isMe: Boolean, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .width(IntrinsicSize.Min),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val borderColor = if (isMe) {
            SolidColor(Color.LightGray)
        } else {
            Brush.linearGradient(
                colors = instagramGradient,
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = 100f, y = 100f)
            )
        }
        Image(
            painter = painterResource(id = item.authorImageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(52.dp)
                .height(52.dp)
                .clip(CircleShape)
                .border(
                    shape = CircleShape,
                    border = BorderStroke(width = 3.dp, brush = borderColor)
                )
        )
        Text(
            text = item.author,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview
@Composable
fun StoryItemPreview() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            StoryItem(
                item = DemoDataProvider.tweet,
                isMe = true
            )
        }
    }
}

@Preview
@Composable
fun StoryItemNotMePreview() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            StoryItem(
                item = DemoDataProvider.tweet,
                isMe = false
            )
        }
    }
}
