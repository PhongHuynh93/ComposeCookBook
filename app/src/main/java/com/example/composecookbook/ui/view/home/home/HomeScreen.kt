package com.example.composecookbook.ui.view.home.home

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecookbook.data.DemoDataProvider
import com.example.composecookbook.data.model.HomeScreenItems
import com.example.composecookbook.ui.theme.ComposeCookBookTheme
import com.example.composecookbook.ui.view.advanceList.AdvanceListsActivity
import com.example.composecookbook.ui.view.dynamic.DynamicUIActivity
import com.example.composecookbook.ui.view.dynamic.DynamicUiType
import com.example.composecookbook.ui.view.listview.ListViewActivity
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(text = "Compose CookBook")
                },
                actions = {

                }
            )
        },
        content = {
            HomeScreenContent()
        }
    )
}

// TODO: support wider screen
@Composable
fun HomeScreenContent() {
    val list = remember { DemoDataProvider.homeScreenListItems }
    LazyColumn(content = {
        items(
            items = list,
            itemContent = {
                HomeScreenListView(it)
            }
        )
    })
}

@Composable
fun HomeScreenListView(homeScreenItems: HomeScreenItems) {
    val context = LocalContext.current
    Button(
        onClick = { homeItemClicked(context, homeScreenItems) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = homeScreenItems.name,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

fun homeItemClicked(context: Context, homeScreenItems: HomeScreenItems) {
    val intent = when (homeScreenItems) {
        is HomeScreenItems.ListView -> {
            ListViewActivity.newIntent(context, homeScreenItems.type.uppercase(Locale.getDefault()))
        }
        HomeScreenItems.Modifiers -> {
            DynamicUIActivity.newIntent(context, DynamicUiType.MODIFIERS.name)
        }
        HomeScreenItems.Layouts -> {
            DynamicUIActivity.newIntent(context, DynamicUiType.LAYOUTS.name)
        }
        HomeScreenItems.ConstraintsLayout -> {
            DynamicUIActivity.newIntent(context, DynamicUiType.CONSTRAINTLAYOUT.name)
        }
        HomeScreenItems.MotionLayout -> {
            DynamicUIActivity.newIntent(context, DynamicUiType.MOTIONLAYOUT.name)
        }
        HomeScreenItems.AdvanceLists -> {
            AdvanceListsActivity.newIntent(context)
        }
        HomeScreenItems.AndroidViews -> TODO()
        HomeScreenItems.BottomAppBar -> TODO()
        HomeScreenItems.BottomSheets -> TODO()
        HomeScreenItems.Carousel -> TODO()
        HomeScreenItems.CollapsingAppBar -> TODO()
        HomeScreenItems.CustomFling -> TODO()
        HomeScreenItems.Dialogs -> TODO()
        HomeScreenItems.PullRefresh -> TODO()
        HomeScreenItems.TabLayout -> TODO()
    }
    context.startActivity(intent)
}

@Preview
@Composable
fun HomeScreenPreview() {
    ComposeCookBookTheme {
        HomeScreen()
    }
}
