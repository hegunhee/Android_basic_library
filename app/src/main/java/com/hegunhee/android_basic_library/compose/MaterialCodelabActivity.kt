package com.hegunhee.android_basic_library.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material.Colors
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable

class MaterialCodelabActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}

@Composable
fun MaterialTheme(
    colors : Colors,
    typography: Typography,
    shapes: Shapes,
    content: @Composable () -> Unit
){

}

@Composable
fun JetnewsTheme(content: @Composable () -> Unit){
}