package com.hegunhee.android_basic_library.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import kotlinx.coroutines.launch

class LayoutCodelabActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BodyContent()
        }
    }
}

@Composable
fun ImageList(){
    val listSize = 100
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Row{
        Button(onClick = {
            coroutineScope.launch {
                scrollState.animateScrollToItem(0)
            }
        }) {
            Text("Scroll to the top")
        }
        Button(onClick = {
            coroutineScope.launch {
                scrollState.animateScrollToItem(listSize-1)
            }
        }){
            Text("Scroll to the end")
        }
    }
    LazyColumn(state = scrollState){
        items(100){
            ImageListItem(index = it)
        }
    }
}
@Composable
fun ImageListItem(index : Int){
    Row(verticalAlignment = Alignment.CenterVertically){
        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text("Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row(modifier
        .padding(16.dp)
        .clickable(onClick = {})){
       Surface(
           modifier = Modifier.size(50.dp),
           shape = CircleShape,
           color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
       ) {
       }
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text("AlfredSisley", fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minites ago", style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Composable
fun MyOwnColumn(
    modifier: Modifier = Modifier,
    content : @Composable () -> Unit
){
    Layout(
        modifier = modifier,
        content = content
    ){ measurables , constraints ->
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }
        var yPosition = 0
        layout(constraints.maxWidth,constraints.maxHeight){
            placeables.forEach{ placeable ->
                placeable.placeRelative(x=0,y=yPosition)

                yPosition += placeable.height
            }
        }
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier){
    MyOwnColumn(modifier.padding(8.dp)) {
        Text("MyOwnColumn")
        Text("places items")
        Text("vertically.")
        Text("We've done it by hand!")
    }
}

fun Modifier.firstBaselineToTop(
    firstBaselineToTop : Dp
) = this.then(
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)

        check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
        val firstBaseline = placeable[FirstBaseline]

        val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
        val height = placeable.height + placeableY
        layout(placeable.width, height){
            placeable.placeRelative(0,placeableY)
        }

    }
)