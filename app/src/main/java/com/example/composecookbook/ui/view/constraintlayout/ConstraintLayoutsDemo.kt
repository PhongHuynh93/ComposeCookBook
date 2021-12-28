package com.example.composecookbook.ui.view.constraintlayout

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.composecookbook.R
import com.example.composecookbook.data.DemoDataProvider
import com.example.composecookbook.ui.theme.ComposeCookBookTheme
import com.example.composecookbook.ui.theme.gradientBluePurple
import com.example.composecookbook.ui.theme.green500
import com.example.composecookbook.ui.theme.typography
import com.example.composecookbook.utils.modifier.horizontalGradientBackground

@Composable
fun ConstraintLayoutsDemo() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        ConstraintLayoutsDemo1()
        ConstraintLayoutsDemo2()
        ConstraintLayoutsDemo3()
        ConstraintLayoutsDemo4()
        ConstraintLayoutsDemo5()
        Spacer(modifier = Modifier.height(300.dp))
    }
}

@Composable
fun ConstraintLayoutsDemo1() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
    ) {
        // refs creations
        val (image, title, subtitle, label, heart) = createRefs()
        val item = DemoDataProvider.item
        Image(
            painter = painterResource(id = item.imageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .clip(CircleShape)
                .constrainAs(image) {
                    top.linkTo(anchor = parent.top)
                    start.linkTo(anchor = parent.start)
                }
        )
        Text(
            text = item.title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(anchor = image.top)
                    start.linkTo(anchor = image.end, margin = 12.dp)
                    end.linkTo(anchor = heart.start, margin = 8.dp)
                    width = Dimension.fillToConstraints
                }
        )
        IconToggleButton(
            checked = false,
            onCheckedChange = {

            },
            modifier = Modifier
                .constrainAs(heart) {
                    top.linkTo(anchor = title.top)
                    bottom.linkTo(anchor = title.bottom)
                    end.linkTo(anchor = parent.end)
                }
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null
            )
        }
        Text(
            text = item.subtitle,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(top = 8.dp)
                .constrainAs(subtitle) {
                    top.linkTo(anchor = title.bottom)
                    start.linkTo(anchor = title.start)
                    end.linkTo(anchor = parent.end)
                    width = Dimension.fillToConstraints
                }
        )
        Text(
            text = item.source,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
                .padding(top = 16.dp)
                .constrainAs(label) {
                    top.linkTo(anchor = subtitle.bottom)
                    start.linkTo(anchor = subtitle.start)
                }
        )
    }
}

@Preview(name = "demo1", widthDp = 300)
@Composable
fun ConstraintLayoutsDemo1Preview() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ConstraintLayoutsDemo1()
        }
    }
}

@Composable
fun ConstraintLayoutsDemo2() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // refs creations
        val (image, title, subtitle, label, heart) = createRefs()
        val item = DemoDataProvider.item
        Image(
            painter = painterResource(id = item.imageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .constrainAs(image) {
                    top.linkTo(anchor = parent.top)
                    start.linkTo(anchor = parent.start)
                }
        )
        Text(
            text = item.title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(anchor = heart.bottom)
                    start.linkTo(anchor = parent.start, margin = 16.dp)
                    end.linkTo(anchor = parent.end, margin = 16.dp)
                    width = Dimension.fillToConstraints
                }
        )
        IconToggleButton(
            checked = false,
            onCheckedChange = {},
            modifier = Modifier
                .constrainAs(heart) {
                    top.linkTo(anchor = parent.top)
                    end.linkTo(anchor = parent.end)
                }
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
            )
        }
        Text(
            text = item.subtitle,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(top = 8.dp)
                .constrainAs(subtitle) {
                    top.linkTo(anchor = title.bottom)
                    start.linkTo(anchor = title.start)
                    end.linkTo(anchor = title.end)
                    width = Dimension.fillToConstraints
                }
        )
        Text(
            text = item.source,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
                .padding(top = 16.dp)
                .constrainAs(label) {
                    top.linkTo(anchor = subtitle.bottom)
                    start.linkTo(anchor = subtitle.start)
                }
        )
    }
}

@Preview(name = "demo2", widthDp = 400)
@Composable
fun ConstraintLayoutsDemo2Preview() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ConstraintLayoutsDemo2()
        }
    }
}

@Composable
fun ConstraintLayoutsDemo3() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        // refs creations
        val (image, title, subtitle, body, star, date) = createRefs()
        val item = DemoDataProvider.tweet
        Image(
            painter = painterResource(id = item.authorImageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(52.dp)
                .height(52.dp)
                .clip(CircleShape)
                .constrainAs(image) {
                    top.linkTo(anchor = parent.top)
                    start.linkTo(anchor = parent.start)
                }
        )
        Text(
            text = item.author,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(anchor = parent.top)
                    start.linkTo(anchor = image.end, margin = 16.dp)
                    end.linkTo(anchor = date.start, margin = 16.dp)
                    width = Dimension.fillToConstraints
                }
        )
        Text(
            text = item.source,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .padding(top = 4.dp)
                .constrainAs(subtitle) {
                    top.linkTo(anchor = title.bottom)
                    start.linkTo(anchor = title.start)
                    end.linkTo(anchor = date.start, margin = 16.dp)
                    width = Dimension.fillToConstraints
                }
        )
        Text(
            text = "5 sept",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
                .constrainAs(date) {
                    top.linkTo(anchor = parent.top)
                    end.linkTo(anchor = parent.end)
                }
        )
        Text(
            text = item.text,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(top = 4.dp)
                .constrainAs(body) {
                    top.linkTo(anchor = subtitle.bottom)
                    start.linkTo(anchor = title.start)
                    end.linkTo(anchor = star.start, margin = 16.dp)
                    width = Dimension.fillToConstraints
                }
        )
        val isStar = remember { mutableStateOf(false) }
        IconToggleButton(
            checked = isStar.value,
            onCheckedChange = {
                isStar.value = it
            },
            modifier = Modifier
                .constrainAs(star) {
                    bottom.linkTo(anchor = parent.bottom)
                    end.linkTo(anchor = parent.end)
                }
        ) {
            if (isStar.value) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                    tint = Color.Yellow
                )
            } else {
                Icon(
                    imageVector = Icons.Default.StarBorder,
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                )
            }
        }
    }
}

@Preview(name = "demo3", widthDp = 500)
@Composable
fun ConstraintLayoutsDemo3Preview() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ConstraintLayoutsDemo3()
        }
    }
}

@Composable
fun ConstraintLayoutsDemo4() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // refs creations
        val (image, body, date, author, icon) = createRefs()
        val item = DemoDataProvider.tweetList.first {
            it.tweetImageId > 0
        }
        Image(
            painter = painterResource(id = item.tweetImageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .constrainAs(image) {
                    top.linkTo(anchor = parent.top)
                    start.linkTo(anchor = parent.start)
                }
        )
        Image(
            painter = painterResource(id = item.authorImageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .padding(start = 12.dp, top = 12.dp)
                .clip(CircleShape)
                .constrainAs(author) {
                    top.linkTo(anchor = image.bottom)
                    start.linkTo(anchor = parent.start)
                }
        )
        Text(
            text = item.text,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(start = 12.dp, top = 12.dp)
                .constrainAs(body) {
                    top.linkTo(anchor = author.top)
                    start.linkTo(anchor = author.end, margin = 12.dp)
                    end.linkTo(anchor = icon.start, margin = 12.dp)
                    width = Dimension.fillToConstraints
                }
        )
        IconButton(
            onClick = {},

            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .constrainAs(icon) {
                    top.linkTo(anchor = author.top)
                    end.linkTo(anchor = parent.end)
                }
        ) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null,
            )
        }
        Text(
            text = "${item.author} . ${item.likesCount}k views . ${item.time} ago",
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier
                .padding(top = 8.dp, start = 12.dp)
                .constrainAs(date) {
                    top.linkTo(anchor = body.bottom)
                    start.linkTo(anchor = body.start)
                    end.linkTo(anchor = parent.end)
                    width = Dimension.fillToConstraints
                }
        )
    }
}

@Preview(name = "demo4", widthDp = 500)
@Composable
fun ConstraintLayoutsDemo4Preview() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ConstraintLayoutsDemo4()
        }
    }
}

@Composable
fun ConstraintLayoutsDemo5() {
    // This is dummy data for crypto wallet
    val paddingWithStatusBarHeight = 30.dp
    var extended by remember { mutableStateOf(false) }
    val animateHeight = if (extended) 500.dp else 200.dp
    val opacity = if (extended) 0.8f else 1f
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(animateDpAsState(animateHeight).value)
            .alpha(animateFloatAsState(opacity).value)
            .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
            .horizontalGradientBackground(gradientBluePurple)
            .padding(top = paddingWithStatusBarHeight, bottom = 8.dp, start = 8.dp, end = 8.dp)
    ) {
        val (title, image, price, asset, dailyChange, send, receive, scan) = createRefs()
        val horizontalCenterGuideline = createGuidelineFromStart(0.5f)
        Icon(
            painter = painterResource(id = R.drawable.ic_ethereum_brands),
            contentDescription = null,
            modifier = Modifier
                .size(28.dp)
                .alpha(0.7f)
                .constrainAs(image) {
                    start.linkTo(parent.start)
                    top.linkTo(title.bottom, margin = 8.dp)
                }
        )
        Text(
            text = "My Wallet",
            style = typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(4.dp)
                .constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = "340.13 USD",
            style = typography.h6,
            modifier = Modifier
                .padding(4.dp)
                .constrainAs(price) {
                    top.linkTo(title.bottom)
                    start.linkTo(image.end)
                }
        )
        Text(
            text = "1.23 ETH",
            textAlign = TextAlign.Right,
            style = typography.h6.copy(fontSize = 12.sp),
            modifier = Modifier
                .padding(start = 4.dp)
                .constrainAs(asset) {
                    top.linkTo(price.bottom)
                    start.linkTo(image.end)
                }
        )
        Text(
            text = "24H: +1.23%",
            color = green500,
            style = typography.body2.copy(fontWeight = FontWeight.Medium),
            modifier = Modifier
                .padding(4.dp)
                .constrainAs(dailyChange) {
                    end.linkTo(parent.end)
                    top.linkTo(price.top)
                }
        )
        ExtendedFloatingActionButton(
            onClick = { extended = !extended },
            modifier = Modifier
                .padding(4.dp)
                .border(1.dp, Color.White, RoundedCornerShape(8.dp))
                .constrainAs(receive) {
                    start.linkTo(parent.start)
                    end.linkTo(horizontalCenterGuideline)
                    top.linkTo(asset.bottom, margin = 16.dp)
                },
            icon = {
                Icon(
                    imageVector = Icons.Default.QrCodeScanner,
                    contentDescription = null,
                    tint = androidx.compose.material.MaterialTheme.colors.onSurface
                )
            },
            text = { Text(text = "Receive") },
            containerColor = Color.Transparent,
        )
        ExtendedFloatingActionButton(
            onClick = { extended = !extended },
            modifier = Modifier
                .padding(4.dp)
                .border(1.dp, Color.White, RoundedCornerShape(8.dp))
                .constrainAs(send) {
                    start.linkTo(horizontalCenterGuideline)
                    end.linkTo(parent.end)
                    top.linkTo(asset.bottom, margin = 16.dp)
                },
            icon = {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = null
                )
            },
            text = { Text(text = "Send") },
            containerColor = Color.Transparent,
        )
        Image(
            imageVector = Icons.Default.QrCodeScanner,
            contentDescription = null,
            modifier = Modifier
                .size(250.dp)
                .alpha(animateFloatAsState(if (extended) 1f else 0f).value)
                .constrainAs(scan) {
                    top.linkTo(receive.bottom, margin = 50.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}

@Preview(name = "demo5", widthDp = 400, heightDp = 800)
@Composable
fun ConstraintLayoutsDemo5Preview() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ConstraintLayoutsDemo5()
        }
    }
}

@Preview
@Composable
fun ConstraintLayoutsDemoPrev() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ConstraintLayoutsDemo()
        }
    }
}
