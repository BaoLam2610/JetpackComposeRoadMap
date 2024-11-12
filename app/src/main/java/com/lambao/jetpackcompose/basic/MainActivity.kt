package com.lambao.jetpackcompose.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lambao.jetpackcompose.basic.ui.ColumnExampleScreen
import com.lambao.jetpackcompose.basic.ui.LoginScreen
import com.lambao.jetpackcompose.basic.ui.RowExampleScreen
import com.lambao.jetpackcompose.basic.ui.ScreenExample
import com.lambao.jetpackcompose.basic.ui.theme.JetpackComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeBasicTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier) { innerPadding ->
//        ColumnExampleScreen(modifier = Modifier.background(Color.Black).padding(innerPadding))
//        RowExampleScreen(modifier = Modifier.background(Color.Black).padding(innerPadding))
//        LoginScreen(modifier = Modifier.padding(innerPadding))
        ScreenExample(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun ColumnText(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(20.dp)
            .padding(start = 30.dp)
    ) {
        Text("Hello")
        Text("Bao Lam")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeBasicTheme {
        Greeting("Android")
    }
}