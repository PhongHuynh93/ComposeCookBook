package com.example.composecookbook.ui.view.listview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecookbook.R
import com.example.composecookbook.ui.theme.ComposeCookBookTheme

enum class ListViewType(string: String) {
    VERTICAL("Vertical"),
    HORIZONTAL("Horizontal"),
    GRID("Grid"),
    MIX("Vertical+Horizontal")
}

class ListViewActivity : ComponentActivity() {

    private val listType: String by lazy {
        intent?.getStringExtra(TYPE) ?: ListViewType.VERTICAL.name
    }

    companion object {
        const val TYPE = "type"

        fun newIntent(context: Context, listViewType: String) =
            Intent(context, ListViewActivity::class.java).apply {
                putExtra(TYPE, listViewType)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCookBookTheme {
                ListViewContent(listType = listType) {
                    onBackPressed()
                }
            }
        }
    }
}

@Composable
fun ListViewContent(listType: String, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Column {
                        Text(text = "ListView")
                        Text(
                            text = listType,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
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
            when (listType) {
                ListViewType.VERTICAL.name -> {
                    VerticalListView()
                }
                ListViewType.HORIZONTAL.name -> {
                    HorizontalListView()
                }
                ListViewType.GRID.name -> {
                    GridListView()
                }
            }
        }
    )
}

@Preview(name = "Vertical page")
@Composable
fun VerticalPagePreview() {
    ComposeCookBookTheme {
        ListViewContent(ListViewType.VERTICAL.name) {}
    }
}

@Preview(name = "Horizontal page")
@Composable
fun HorizontalPagePreview() {
    ComposeCookBookTheme {
        ListViewContent(ListViewType.HORIZONTAL.name) {}
    }
}
