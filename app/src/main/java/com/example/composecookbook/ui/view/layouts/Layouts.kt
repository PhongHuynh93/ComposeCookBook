package com.example.composecookbook.ui.view.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.composecookbook.ui.theme.ComposeCookBookTheme
import com.example.composecookbook.ui.theme.Purple500
import com.example.composecookbook.ui.theme.Purple700
import com.example.composecookbook.ui.theme.Teal200

@Composable
fun Layouts() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Text(
            text = "Rows",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Medium)
        )

        LayoutsText(text = "Arrangement.Start")
        Row {
            RowText(text = "First")
            RowText(text = "Second", modifier = Modifier.padding(start = 24.dp))
            RowText(text = "Third", modifier = Modifier.padding(start = 24.dp))
        }

        LayoutsText(text = "Arrangement.End")
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            RowText(text = "First")
            RowText(text = "Second", modifier = Modifier.padding(start = 24.dp))
            RowText(text = "Third", modifier = Modifier.padding(start = 24.dp))
        }

        LayoutsText(text = "Arrangement.Center")
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            RowText(text = "First")
            RowText(text = "Second", modifier = Modifier.padding(start = 24.dp))
            RowText(text = "Third", modifier = Modifier.padding(start = 24.dp))
        }

        LayoutsText(text = "Arrangement.SpaceAround")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray), horizontalArrangement = Arrangement.SpaceAround
        ) {
            RowText(text = "First")
            RowText(text = "Second")
            RowText(text = "Third")
        }

        LayoutsText(text = "Arrangement.SpaceBetween")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RowText(text = "First")
            RowText(text = "Second")
            RowText(text = "Third")
        }

        LayoutsText(text = "Arrangement.SpaceEvenly")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            RowText(text = "First")
            RowText(text = "Second")
            RowText(text = "Third")
        }
    }
}

@Composable
fun LayoutsColumn() {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Text(
            text = "Column",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Medium)
        )
        LayoutsText(text = "Arrangement.Top")
        Column(
            modifier = Modifier
                .height(100.dp)
                .background(Color.Gray)
        ) {
            RowText(text = "First")
            RowText(text = "Second", modifier = Modifier.padding(top = 8.dp))
            RowText(text = "Third", modifier = Modifier.padding(top = 8.dp))
        }
        LayoutsText(text = "Arrangement.Bottom")
        Column(
            verticalArrangement = Arrangement.Bottom, modifier = Modifier
                .height(100.dp)
                .background(
                    Color.Gray
                )
        ) {
            RowText(text = "First")
            RowText(text = "Second", modifier = Modifier.padding(top = 8.dp))
            RowText(text = "Third", modifier = Modifier.padding(top = 8.dp))
        }
        LayoutsText(text = "Arrangement.Center")
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(
                    Color.Gray
                )
        ) {
            RowText(text = "First")
            RowText(text = "Second", modifier = Modifier.padding(top = 8.dp))
            RowText(text = "Third", modifier = Modifier.padding(top = 8.dp))
        }
        LayoutsText(text = "Arrangement.SpaceAround")
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(
                    Color.Gray
                )
        ) {
            RowText(text = "First")
            RowText(text = "Second")
            RowText(text = "Third")
        }
    }
}

@Composable
fun LayoutsBox() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        LayoutsText(text = "Children with no align")
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp), backgroundColor = Teal200
            ) {}
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp),
                backgroundColor = Purple700
            ) {}
            Card(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                backgroundColor = Purple500
            ) {}
        }

        LayoutsText(text = "Children with top start, center, bottom end")
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .align(Alignment.TopStart),
                backgroundColor = Teal200
            ) {}
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .align(Alignment.Center),
                backgroundColor = Purple700
            ) {}
            Card(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .align(Alignment.BottomEnd),
                backgroundColor = Purple500
            ) {}
        }
    }
}

@Composable
fun LayoutsConstraintLayout() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        LayoutsText(text = "Constraint layout")
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            //refs creations
            val (mainButton, mainText, secondaryText, outlineButton) = createRefs()

            Button(onClick = { /*TODO*/ },
                modifier = Modifier.constrainAs(mainButton) {
                    top.linkTo(anchor = parent.top, margin = 16.dp)
                }
            ) {
                Text(text = "Main button")
            }

            Text(text = "Main Text",
                modifier = Modifier.constrainAs(mainText) {
                    start.linkTo(anchor = mainButton.end, margin = 16.dp)
                    top.linkTo(anchor = mainButton.top, margin = 16.dp)
                }
            )

            Text(text = "Secondary Text",
                modifier = Modifier.constrainAs(secondaryText) {
                    start.linkTo(anchor = mainButton.end, margin = 16.dp)
                    top.linkTo(anchor = mainText.bottom, margin = 16.dp)
                }
            )

            OutlinedButton(onClick = { /*TODO*/ },
                modifier = Modifier.constrainAs(outlineButton) {
                    top.linkTo(anchor = secondaryText.bottom, margin = 16.dp)
                    end.linkTo(anchor = parent.end, margin = 16.dp)
                }
            ) {
                Text("Outline Button")
            }
        }
    }
}

@Composable
fun LayoutsText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall,
        modifier = modifier,
    )
}

@Composable
fun RowText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier,
    )
}

@Preview(name = "Rows")
@Composable
fun LayoutsRowPrev() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            Layouts()
        }
    }
}

@Preview(name = "Column")
@Composable
fun LayoutsColumnPrev() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            LayoutsColumn()
        }
    }
}

@Preview(name = "Box", widthDp = 500)
@Composable
fun LayoutsBoxPrev() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            LayoutsBox()
        }
    }
}

@Preview(name = "Constraint", widthDp = 500)
@Composable
fun LayoutsConstraintLayoutPrev() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            LayoutsConstraintLayout()
        }
    }
}
