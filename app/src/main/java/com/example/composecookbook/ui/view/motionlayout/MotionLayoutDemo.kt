package com.example.composecookbook.ui.view.motionlayout

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.MotionLayout
import com.example.composecookbook.R
import com.example.composecookbook.ui.theme.ComposeCookBookTheme

@Composable
fun MotionLayoutDemo() {
    Column {
        ButtonsMotionExample()
        Spacer(modifier = Modifier.height(200.dp))
        ImageMotionExample()
    }
}

@Composable
fun ButtonsMotionExample() {
    var animateButton by remember { mutableStateOf(false) }
    val buttonAnimationProgress by animateFloatAsState(
        targetValue = if (animateButton) 1f else 0f,
        animationSpec = tween(1500)
    )
    Spacer(modifier = Modifier.height(16.dp))
    MotionLayout(
        ConstraintSet(
            """ {
                button1: { 
                  width: "spread",
                  height: 60,
                  start: ['parent', 'start', 16],
                  end: ['parent', 'end', 16],
                  top: ['parent', 'top', 16]
                },
                button2: { 
                  width: "spread",
                  height: 60,
                  start: ['parent', 'start', 16],
                  end: ['parent', 'end', 16],
                  top: ['button1', 'bottom', 16]
                },
                button3: { 
                  width: "spread",
                  height: 60,
                  start: ['parent', 'start', 16],
                  end: ['parent', 'end', 16],
                  top: ['button2', 'bottom', 16]
                }
            } """
        ),
        ConstraintSet(
            """ {
                button1: { 
                  width: 150,
                  height: 60,
                  start: ['parent', 'start', 16],
                  end: ['button2', 'start', 16]
                },
                button2: { 
                  width: 150,
                  height: 60,
                  start: ['button1', 'end', 16],
                  end: ['button2', 'start', 16]
                },
                button3: { 
                  width: 150,
                  height: 60,
                  start: ['button2', 'end', 16],
                  end: ['parent', 'end', 16]
                }
            } """
        ),
        progress = buttonAnimationProgress,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Button(
            onClick = { animateButton = !animateButton },
            modifier = Modifier.layoutId("button1")
        ) {
            Text(text = "Button1")
        }
        Button(
            onClick = { animateButton = !animateButton },
            modifier = Modifier.layoutId("button2")
        ) {
            Text(text = "Button2")
        }
        Button(
            onClick = { animateButton = !animateButton },
            modifier = Modifier.layoutId("button3")
        ) {
            Text(text = "Button3")
        }
    }
}


@Preview
@Composable
fun ButtonsMotionExamplePrev() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ButtonsMotionExample()
        }
    }
}

@Composable
fun ImageMotionExample() {
    var animateButton by remember { mutableStateOf(false) }
    val buttonAnimationProgress by animateFloatAsState(
        targetValue = if (animateButton) 1f else 0f,
        animationSpec = tween(1500)
    )
    Spacer(modifier = Modifier.height(16.dp))
    MotionLayout(
        ConstraintSet(
            """ {
                image1: { 
                  width: "150",
                  height: "150",
                  start: ['parent', 'start'],
                },
                image2: { 
                  width: "150",
                  height: "150",
                  start: ['parent', 'start', 8],
                },
                image3: { 
                  width: "150",
                  height: "150",
                  start: ['parent', 'start', 16],
                },
                image4: { 
                  width: "150",
                  height: "150",
                  start: ['parent', 'start', 24],
                }
            } """
        ),
        ConstraintSet(
            """ {
               image1: { 
                  width: "150",
                  height: "150",
                  start: ['parent', 'start'],
                },
                image2: { 
                  width: "150",
                  height: "150",
                  start: ['image1', 'end', 16],
                },
                image3: { 
                  width: "150",
                  height: "150",
                  start: ['parent', 'start'],
                  top: ['image1', 'bottom', 16]
                },
                image4: { 
                  width: "150",
                  height: "150",
                  start: ['image1', 'end', 16],
                  top: ['image1', 'bottom', 16]
                }
            } """
        ),
        progress = buttonAnimationProgress,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.edsheeran),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .layoutId("image1")
                .clickable {
                    animateButton = !animateButton
                }
        )
        Image(
            painter = painterResource(id = R.drawable.camelia),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .layoutId("image2")
                .clickable {
                    animateButton = !animateButton
                }
        )
        Image(
            painter = painterResource(id = R.drawable.bp),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .layoutId("image3")
                .clickable {
                    animateButton = !animateButton
                }
        )
        Image(
            painter = painterResource(id = R.drawable.ed2),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .layoutId("image4")
                .clickable {
                    animateButton = !animateButton
                }
        )
    }
}

@Preview
@Composable
fun ImageMotionExamplePrev() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ImageMotionExample()
        }
    }
}

@Preview
@Composable
fun MotionLayoutDemoPrev() {
    ComposeCookBookTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            MotionLayoutDemo()
        }
    }
}
