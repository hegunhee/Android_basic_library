package com.hegunhee.android_basic_library.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class CodelabActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colors.primary) {
                MyApp()
            }

        }
    }
}

@Composable
fun MyApp(names: List<String> = listOf("World", "Compose")) {
    var shouldShowOnBoarding by remember{ mutableStateOf(true)}
    if(shouldShowOnBoarding){
        OnboardingScreen(onContinueClicked = {shouldShowOnBoarding= false})
    }else{
        Greetings()
    }
}

@Composable
private fun Greetings(names : List<String> = listOf("World","Compose")){
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        for(name in names){
            Greeting(name= name)
        }

    }
}
@Composable
fun Greeting(name: String) {
    val expanded = remember{ mutableStateOf(false)}

    val extraPadding = if (expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)){
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)) {
                Text(text = "Hello, ")
                Text(text = "$name!")
            }
            OutlinedButton(onClick = { expanded.value = !expanded.value }) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }

    }
}

@Composable
fun OnboardingScreen(onContinueClicked : () -> Unit){
    var shouldShowOnboarding by remember  { mutableStateOf(true)}
    Surface{
        Column(
            modifier =Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text("Welcome to the basic Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            ){
                Text("Continue")
            }
        }

    }
}
