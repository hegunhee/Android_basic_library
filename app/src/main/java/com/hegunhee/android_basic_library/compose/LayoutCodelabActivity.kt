package com.hegunhee.android_basic_library.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class LayoutCodelabActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotographerCard()
        }
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