package com.example.composecookbook.ui.view.listview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecookbook.ui.theme.ComposeCookBookTheme

class ListViewActivity : ComponentActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, ListViewActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCookBookTheme {
                ListViewContent()
            }
        }
    }
}

@Composable
fun ListViewContent() {
    Text(text = "ListView")
}

@Preview
@Composable
fun DefaultPreview() {
    ComposeCookBookTheme {
        ListViewContent()
    }
}
