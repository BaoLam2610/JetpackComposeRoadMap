package com.lambao.jetpackcompose.basic

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun CalculatorScreen(modifier: Modifier = Modifier) {

    val viewModel = viewModel<CalculatorViewModel>()
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NumberInputArea(
                input = viewModel.input.value
            )
            ResultCalculatorArea(
                result = "0"
            )
            NumberCalculationArea()
        }
    }
}

@Composable
fun NumberInputArea(modifier: Modifier = Modifier, input: String) {
    Text(
        input,
        style = MaterialTheme.typography.displayLarge,
        modifier = modifier,
        textAlign = TextAlign.End
    )
}

@Composable
fun ResultCalculatorArea(modifier: Modifier = Modifier, result: String) {
    Text(
        result,
        style = MaterialTheme.typography.displayLarge,
        modifier = modifier,
        textAlign = TextAlign.End
    )
}

@Composable
fun NumberCalculationArea(modifier: Modifier = Modifier) {
    Row(modifier.fillMaxSize(), verticalAlignment = Alignment.Bottom) {
        ColumnNumber(modifier = modifier.weight(1f))
        ColumnCalculation(modifier = modifier)
    }
}

@Composable
fun ColumnNumber(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom
    ) {
        GridNumberArea(
            modifier = Modifier.fillMaxWidth(),
            number = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        )
        FooterNumber(
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ColumnCalculation(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom
    ) {
        listOf("+", "-", "x", "/").forEach {
            CharacterItem(
                modifier = Modifier.width(80.dp),
                character = it
            )
        }
    }
}

@Composable
fun GridNumberArea(modifier: Modifier = Modifier, number: List<Int>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
    ) {
        items(number) {
            NumberItem(number = it)
        }
    }
}

@Composable
fun NumberItem(modifier: Modifier = Modifier, number: Int) {
    Surface(
        modifier = modifier.clickable(onClick = {

        }),
        color = Color.White,
    ) {
        CharacterItem(
            character = number.toString()
        )
    }
}

@Composable
fun FooterNumber(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        listOf("0", ".", "=").forEach {
            CharacterItem(
                modifier = Modifier.weight(1f),
                character = it
            )
        }
    }
}

@Composable
fun CharacterItem(modifier: Modifier = Modifier, character: String) {
    Text(
        character,
        modifier = modifier
            .background(Color.White)
            .padding(10.dp),
        textAlign = TextAlign.Center,
        color = Color.Black
    )
}