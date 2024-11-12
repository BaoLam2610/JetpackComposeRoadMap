package com.lambao.jetpackcompose.basic.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ScreenExample(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        ButtonRow("Hello World", "Button")
        Spacer(modifier = Modifier.height(4.dp))
        ButtonRow("Hello Jetpack Compose", "ElevatedButton", buttonType = ButtonType.Elevated)
        Spacer(modifier = Modifier.height(4.dp))
        ButtonRow("Hello Jetpack Compose", "FilledTonalButton", buttonType = ButtonType.FilledTonal)
        Spacer(modifier = Modifier.height(4.dp))
        ButtonRow("Hello Jetpack Compose", "OutlinedButton", buttonType = ButtonType.Outlined)
        Spacer(modifier = Modifier.height(4.dp))
        ButtonRow("Hello Jetpack Compose", "TextButton", buttonType = ButtonType.Text)
    }
}

@Composable
fun ButtonRow(
    text: String,
    buttonText: String,
    modifier: Modifier = Modifier,
    buttonType: ButtonType = ButtonType.Default
) {
    var isExpanded by remember { mutableStateOf(false) }
    val heightExpanded = if (isExpanded) 100.dp else 0.dp

    Surface(
        modifier = modifier
            .fillMaxWidth(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Row(
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 10.dp, vertical = 12.dp)
                .padding(bottom = heightExpanded),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text)
            when (buttonType) {
                ButtonType.Default -> Button(
                    onClick = { isExpanded = !isExpanded },
                    modifier = Modifier.height(40.dp),
                    contentPadding = PaddingValues(vertical = 10.dp, horizontal = 20.dp)
                ) {
                    Text(buttonText)
                }

                ButtonType.Elevated -> ElevatedButton(
                    onClick = { isExpanded = !isExpanded },
                    modifier = Modifier.height(40.dp),
                    contentPadding = PaddingValues(vertical = 10.dp, horizontal = 20.dp)
                ) {
                    Text(buttonText)
                }

                ButtonType.FilledTonal -> FilledTonalButton(
                    onClick = { isExpanded = !isExpanded },
                    modifier = Modifier.height(40.dp),
                    contentPadding = PaddingValues(vertical = 10.dp, horizontal = 20.dp)
                ) {
                    Text(buttonText)
                }

                ButtonType.Outlined -> OutlinedButton(
                    onClick = { isExpanded = !isExpanded },
                    modifier = Modifier.height(40.dp),
                    contentPadding = PaddingValues(vertical = 10.dp, horizontal = 20.dp)
                ) {
                    Text(buttonText)
                }

                ButtonType.Text -> TextButton(
                    onClick = { isExpanded = !isExpanded },
                    modifier = Modifier.height(40.dp),
                    contentPadding = PaddingValues(vertical = 10.dp, horizontal = 20.dp)
                ) {
                    Text(buttonText)
                }
            }
        }
    }
}

enum class ButtonType {
    Default, Elevated, FilledTonal, Outlined, Text
}