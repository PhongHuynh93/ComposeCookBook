package com.example.composecookbook.ui.view.dynamic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecookbook.ui.theme.ComposeCookBookTheme
import com.example.composecookbook.ui.theme.Purple200
import com.example.composecookbook.ui.theme.Purple500

@Composable
fun HowToModifiers() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Text(
            text = "Order in modifier values matters",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Medium)
        )
        HMText(
            text = "No modifiers",
        )
        HMButton(text = "Basic Button")
        Spacer(modifier = Modifier.height(24.dp))

        HMText(
            text = "Modifier.fillMaxWidth",
        )
        HMButton(text = "Basic Button", modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(24.dp))

        HMText(
            text = "Modifier.fillMaxWidth.padding(12)",
        )
        HMButton(
            text = "Basic Button",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))

        HMText(
            text = "Modifier.size(100dp)",
        )
        HMButton(
            text = "Basic Button",
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))

        HMText(
            text = "Modifier.height(50).width(200)",
        )
        HMButton(
            text = "Basic Button",
            modifier = Modifier
                .width(200.dp)
                .height(50.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))

        HMText(
            text = "Modifier.clip(CircleShape)",
        )
        HMButton(
            text = "Basic Button",
            modifier = Modifier
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(24.dp))

        // new modifier
        HMText(
            text = "Modifier.clip(RoundedCornerShape)",
        )
        HMButton(
            text = "Basic Button",
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
        )
        Spacer(modifier = Modifier.height(24.dp))

        // new modifier
        HMText(
            text = "Modifier.clip(RoundedCornerShape)",
        )
        HMButton(
            text = "Basic Button",
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 4.dp,
                        bottomEnd = 4.dp
                    )
                )
        )
        Spacer(modifier = Modifier.height(24.dp))

        // new modifier
        HMText(
            text = "align center hoz",
        )
        HMButton(
            text = "Basic Button",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(24.dp))

        // new modifier
        HMText(
            text = "align center end",
        )
        HMButton(
            text = "Basic Button",
            modifier = Modifier
                .align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(24.dp))

        // new modifier
        HMText(
            text = "alpha 0.5",
        )
        HMButton(
            text = "Basic Button",
            modifier = Modifier
                .alpha(0.5f)
        )
        Spacer(modifier = Modifier.height(24.dp))

        // new modifier
        HMText(
            text = "draw shadow",
        )
        HMButton(
            text = "Basic Button",
            modifier = Modifier
                .shadow(elevation = 12.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))

        // new modifier
        HMText(text = "bg")
        HMButton(
            text = "Basic Button",
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary)
        )
        Spacer(modifier = Modifier.height(24.dp))

        // new modifier
        HMText(text = "gradient bg")
        Text(
            text = "Basic Button",
            modifier = Modifier
                .padding(8.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Purple200, Purple500)
                    )
                )
        )
        Spacer(modifier = Modifier.height(24.dp))

        // new modifier
        HMText(text = "gradient bg 2")
        Text(
            text = "Basic Button",
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Purple200, Purple500)
                    )
                )
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun HMText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium.copy(Color.Gray),
        modifier = modifier,
    )
}

@Composable
fun HMButton(text: String, modifier: Modifier = Modifier) {
    Button(modifier = modifier, onClick = { /*TODO*/ }) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium.copy(MaterialTheme.colorScheme.onPrimary),
        )
    }
}

@Preview(heightDp = 2000)
@Composable
fun HowToModifiersPrev() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            HowToModifiers()
        }
    }
}
