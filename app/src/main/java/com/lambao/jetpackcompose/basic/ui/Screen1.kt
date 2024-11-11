package com.lambao.jetpackcompose.basic.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColumnExampleScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(Color.Blue)
        )

        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(Color.Red)
        )

        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(Color.Magenta)
        )
    }
}

@Composable
fun RowExampleScreen(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
                .background(Color.Blue)
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
                .background(Color.Green)
        )
    }
}