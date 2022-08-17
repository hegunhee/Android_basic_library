package com.hegunhee.android_basic_library.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment

class StateCodelabActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                WellnessScreen()
            }
        }
    }
}

@Composable
fun WellnessTaskItem(
    taskName: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskName
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")

        }
    }
}

@Composable
fun StatelessCounter(count : Int, onIncrement : () -> Unit,modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(16.dp)) {
        if(count > 0){
            Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement,Modifier.padding(top = 8.dp), enabled = count < 10){
            Text("Add one")
        }

    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier){
    var waterCount by remember { mutableStateOf(0)}

    var juiceCount by remember { mutableStateOf(0)}
    StatelessCounter(count = waterCount, onIncrement = { waterCount++})
    StatelessCounter(count = juiceCount, onIncrement = { juiceCount++ })
}
@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by rememberSaveable { mutableStateOf(0) }
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = { count++ }, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    StatefulCounter(modifier)
}