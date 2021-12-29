package com.example.composecookbook.ui.view.advanceList

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecookbook.ui.theme.ComposeCookBookTheme

@Composable
fun AnimatedLists() {

}

@Preview
@Composable
fun AnimatedListsPrev() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            AnimatedLists()
        }
    }
}
