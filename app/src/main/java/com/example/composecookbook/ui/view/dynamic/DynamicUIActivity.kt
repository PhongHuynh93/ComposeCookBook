package com.example.composecookbook.ui.view.dynamic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecookbook.R
import com.example.composecookbook.ui.theme.ComposeCookBookTheme
import com.example.composecookbook.ui.view.constraintlayout.ConstraintLayoutsDemo
import com.example.composecookbook.ui.view.layouts.Layouts
import com.example.composecookbook.ui.view.motionlayout.MotionLayoutDemo

enum class DynamicUiType {
    TABS,
    BOTTOMSHEET,
    LAYOUTS,
    CONSTRAINTLAYOUT,
    CAROUSELL,
    MODIFIERS,
    ANDROIDVIEWS,
    PULLRERESH,
    MOTIONLAYOUT
}

class DynamicUIActivity : ComponentActivity() {
    private val dynamicUiType: String by lazy {
        intent?.getStringExtra(TYPE) ?: DynamicUiType.TABS.name
    }

    companion object {
        const val TYPE = "type"

        fun newIntent(context: Context, dynamicUiType: String) =
            Intent(context, DynamicUIActivity::class.java).apply {
                putExtra(TYPE, dynamicUiType)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCookBookTheme {
                DynamicUIContent(uiType = dynamicUiType) {
                    onBackPressed()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicUIContent(uiType: String, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(text = uiType)
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
            // We setup a base activity and we will change content depending upon ui type so
            // we don't have to create Activity for every feature showcase
            when (uiType) {
                DynamicUiType.MODIFIERS.name -> {
                    HowToModifiers()
                }
                DynamicUiType.LAYOUTS.name -> {
                    Layouts()
                }
                DynamicUiType.CONSTRAINTLAYOUT.name -> {
                    ConstraintLayoutsDemo()
                }
                DynamicUiType.MOTIONLAYOUT.name -> {
                    MotionLayoutDemo()
                }
            }
        }
    )
}

@Preview
@Composable
fun DynamicUIPreview() {

}
