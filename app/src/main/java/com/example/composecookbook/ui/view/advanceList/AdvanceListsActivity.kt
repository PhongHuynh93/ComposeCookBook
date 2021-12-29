package com.example.composecookbook.ui.view.advanceList

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecookbook.R
import com.example.composecookbook.ui.theme.ComposeCookBookTheme
import com.example.composecookbook.ui.view.advanceList.AdvanceListsActivity.Companion.tabs
import com.example.composecookbook.ui.view.widget.carousel.Pager
import com.example.composecookbook.ui.view.widget.carousel.PagerState

@OptIn(ExperimentalMaterial3Api::class)
class AdvanceListsActivity : ComponentActivity() {

    companion object {
        val tabs = listOf("Shimmers", "Animated Lists", "Swipeable Lists")
        fun newIntent(context: Context) =
            Intent(context, AdvanceListsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCookBookTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        SmallTopAppBar(
                            title = { androidx.compose.material3.Text(text = "Advance Lists(In Progress)") },
                            navigationIcon = {
                                IconButton(onClick = { onBackPressed() }) {
                                    Icon(
                                        Icons.Filled.ArrowBack,
                                        contentDescription = stringResource(id = R.string.cd_back)
                                    )
                                }
                            }
                        )
                    }
                ) {
                    AdvanceListContent()
                }
            }
        }
    }
}

@Composable
fun AdvanceListContent() {
    var selectedIndex by remember { mutableStateOf(0) }
    val pagerState: PagerState = remember {
        PagerState(0, 0, tabs.size - 1)
    }
    Column {
        ScrollableTabRow(
            backgroundColor = MaterialTheme.colorScheme.surface,
            selectedTabIndex = selectedIndex,
            edgePadding = 12.dp
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = index == selectedIndex,
                    onClick = {
                        selectedIndex = tabs.indexOf(title)
                        pagerState.currentPage = tabs.indexOf(title)
                    },
                    text = { androidx.compose.material3.Text(title) }
                )
            }
        }
        Pager(state = pagerState, modifier = Modifier.weight(1f)) {
            selectedIndex = pagerState.currentPage
            when (commingPage) {
                0 -> ShimmerList()
                1 -> AnimatedLists()
                2 -> SwipeableLists()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AdvanceListContentPreview() {
    ComposeCookBookTheme {
        AdvanceListContent()
    }
}