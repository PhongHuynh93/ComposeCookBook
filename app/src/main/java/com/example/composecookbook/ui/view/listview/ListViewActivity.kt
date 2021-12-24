package com.example.composecookbook.ui.view.listview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecookbook.R
import com.example.composecookbook.data.DemoDataProvider
import com.example.composecookbook.ui.theme.ComposeCookBookTheme

class ListViewActivity : ComponentActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, ListViewActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCookBookTheme {
                ListViewContent {
                    onBackPressed()
                }
            }
        }
    }
}

@Composable
fun ListViewContent(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(text = "ListView")
                },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.cd_back),
                        )
                    }
                }
            )
        },
        content = {
            VerticalListView()
        }
    )
}

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
fun ListItemDivider() {
    Divider(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f)
    )
}

@Preview
@Composable
fun DefaultPreview() {
    ComposeCookBookTheme {
        ListViewContent {

        }
    }
}
